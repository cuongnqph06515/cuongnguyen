package com.migi.springapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int code;
    private Boolean status;
    private String error;
    private String message;
    private Object data;
}
