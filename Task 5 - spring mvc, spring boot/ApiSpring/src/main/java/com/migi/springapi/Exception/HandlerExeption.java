package com.migi.springapi.Exception;

import com.migi.springapi.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExeption {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse babRequest(){
        return new ApiResponse(400, false, "Bad request", "Thông báo lỗi", null);
    }
}
