package com.bidea.factory.bookhouse.service.impl;

import com.bidea.factory.bookhouse.bean.Book;
import com.bidea.factory.bookhouse.dto.ApiResponse;
import com.bidea.factory.bookhouse.dto.DiscountDTO;
import com.bidea.factory.bookhouse.model.BookRequest;
import com.bidea.factory.bookhouse.model.BookResponse;
import com.bidea.factory.bookhouse.model.ErrorResponse;
import com.bidea.factory.bookhouse.repository.BookHouseRepository;
import com.bidea.factory.bookhouse.service.BookHouseService;
import com.bidea.factory.bookhouse.util.Util;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class BookHouseServiceImpl implements BookHouseService {
    @Autowired
    private BookHouseRepository bookHouseRepository;
    @Autowired
    private WebClient webClient;

    @Override
    public ApiResponse<?> save(BookRequest bookRequest) {

        if(bookRequest.getDiscountCode()!=null){

            DiscountDTO discountResponse = webClient.post()
                    .body(Mono.just(DiscountDTO.builder()
                            .userId(bookRequest.getId())
                            .houseId(bookRequest.getHouseId())
                            .discountCode(bookRequest.getDiscountCode())
                            .build()), DiscountDTO.class)
                    .retrieve()
                    .bodyToMono(DiscountDTO.class)
                    .timeout(Duration.ofSeconds(5))
                    .retryWhen(Retry.backoff(3, Duration.ofSeconds(5))
                            .doBeforeRetry(x -> log.error("time {} Retrying {} ", LocalDateTime.now(), x.totalRetries())))
                    .doOnNext(x -> System.out.println(x))
                    .onErrorResume(e -> {
                        log.error("Error occurred: {}", e.getMessage());                    ;
                        return Mono.just(DiscountDTO.builder().passedRetry(true).build());
                    })
                    .block();

            log.info("WebClient Response {}",discountResponse);

            if(discountResponse.isPassedRetry()){
                return new ApiResponse<>(Util.getInstance().setErrorReponse(BigDecimal.valueOf(408),"Retrying", "Timeout"));
            }

            if(!discountResponse.isStatus()){
                return new ApiResponse<>(Util.getInstance().setErrorReponse(BigDecimal.valueOf(400),"Conflict", "Invalid Discount"));
            }
        }

        bookHouseRepository.save(Book
                .builder()
                .id(bookRequest.getId())
                .name(bookRequest.getName())
                .lastname(bookRequest.getLastname())
                .age(bookRequest.getAge())
                .phoneNumber(bookRequest.getPhoneNumber())
                .startDate(bookRequest.getStartDate())
                .endDate(bookRequest.getEndDate())
                .houseId(bookRequest.getHouseId())
                .discountCode(bookRequest.getDiscountCode())
                .build());


        return new ApiResponse<>(new BookResponse(BigDecimal.valueOf(200),"Book Accepted"));
    }

    @Override
    public List<Book> getAll() {
        return bookHouseRepository.findAll();
    }

}
