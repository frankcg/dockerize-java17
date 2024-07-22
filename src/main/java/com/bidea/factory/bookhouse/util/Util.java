package com.bidea.factory.bookhouse.util;

import com.bidea.factory.bookhouse.dto.ApiResponse;
import com.bidea.factory.bookhouse.model.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
public class Util {

    private static Util instance = null;

    public static Util getInstance() {
        if ( instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public ErrorResponse setErrorReponse(BigDecimal statusCode, String error, String message){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(statusCode);
        errorResponse.setError(error);
        errorResponse.setMessage(message);
        return errorResponse;
    }
}
