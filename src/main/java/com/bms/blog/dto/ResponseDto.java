package com.bms.blog.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private boolean result;
    private Object message;

    public ResponseDto(boolean result, Object message) {
        this.result = result;
        this.message = message;
    }
}
