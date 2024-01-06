package com.example.demo.exception;

import lombok.Data;

@Data
public class StudentExceptionResponse {
    private String message;

    public StudentExceptionResponse(String message) {
        this.message = message;
    }
}
