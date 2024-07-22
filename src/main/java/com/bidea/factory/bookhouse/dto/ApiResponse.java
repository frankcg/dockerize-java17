package com.bidea.factory.bookhouse.dto;

import com.bidea.factory.bookhouse.model.BookResponse;
import com.bidea.factory.bookhouse.model.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private T data;

}
