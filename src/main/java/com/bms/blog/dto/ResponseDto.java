package com.bms.blog.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private boolean result;
    private String message;

    public ResponseDto(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
}
