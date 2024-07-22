package com.bidea.factory.bookhouse;

import com.bidea.factory.bookhouse.bean.Book;
import com.bidea.factory.bookhouse.dto.ApiResponse;
import com.bidea.factory.bookhouse.model.BookRequest;
import com.bidea.factory.bookhouse.model.BookResponse;
import com.bidea.factory.bookhouse.model.ErrorResponse;
import com.bidea.factory.bookhouse.repository.BookHouseRepository;
import com.bidea.factory.bookhouse.service.BookHouseService;
import com.bidea.factory.bookhouse.service.impl.BookHouseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookhouseApplicationTests {
	@Autowired
	private BookHouseService bookHouseService;

	@Test
	public void testServiceSave() {

		ApiResponse expectedResponse1 = new ApiResponse<>(getExpectedResponse1());
		ApiResponse expectedResponse2 = new ApiResponse<>(getExpectedResponse2());

		ApiResponse<?> response = bookHouseService.save(loadRequest());
		if(response.getData().equals(expectedResponse1)){
			Assertions.assertEquals(expectedResponse1, response);
		}else{
			Assertions.assertEquals(expectedResponse2, response);
		}
	}

	public BookResponse getExpectedResponse1(){
		return new BookResponse(BigDecimal.valueOf(200),"Book Accepted");
	}

	public ErrorResponse getExpectedResponse2(){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(BigDecimal.valueOf(400));
		errorResponse.setError("Conflict");
		errorResponse.setMessage("Invalid Discount");
		return errorResponse;
	}

	public BookRequest loadRequest(){
		BookRequest request = new BookRequest("UID-003",
				"Sebastian",
				"Cabrera",
				BigDecimal.valueOf(29),
				"51997446829",
				LocalDate.parse("2025-01-01"),
				LocalDate.parse("2025-01-02"),
				"98765431-HS");
		request.setDiscountCode("54321");
		return request;
	}

}
