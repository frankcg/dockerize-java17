package com.bidea.factory.bookhouse.service;

import com.bidea.factory.bookhouse.bean.Book;
import com.bidea.factory.bookhouse.dto.ApiResponse;
import com.bidea.factory.bookhouse.model.BookRequest;
import com.bidea.factory.bookhouse.model.BookResponse;
import lombok.Data;

import java.util.List;
import java.util.Objects;

public interface BookHouseService {

    ApiResponse<?> save (BookRequest bookRequest);
    List<Book> getAll ();
}
