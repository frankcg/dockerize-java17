package com.bidea.factory.bookhouse.controller;

import com.bidea.factory.bookhouse.bean.Book;
import com.bidea.factory.bookhouse.dto.ApiResponse;
import com.bidea.factory.bookhouse.model.BookRequest;
import com.bidea.factory.bookhouse.model.BookResponse;
import com.bidea.factory.bookhouse.service.BookHouseService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/v1/bideafactory")
public class BookHouseController {
    @Autowired
    private BookHouseService bookHouseService;

    @PostMapping("/book")
    private ResponseEntity<ApiResponse<?>> save(@Valid @RequestBody BookRequest bookRequest){

        try{
            log.info("[START][POST] /v1/bideafactory/book {}", bookRequest);
            return ResponseEntity.ok(bookHouseService.save(bookRequest));
        } finally {
            log.info("[END][POST] /v1/bideafactory/book {}", bookRequest);
        }

    }

    @GetMapping("/book")
    private ResponseEntity<List<Book>> getAll(){
        try{
            log.info("[START][GET] /v1/bideafactory/book");
            return ResponseEntity.ok(bookHouseService.getAll());
        } finally {
            log.info("[END][GET] /v1/bideafactory/book");
        }
    }

}
