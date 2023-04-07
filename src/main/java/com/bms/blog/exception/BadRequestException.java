package com.bms.blog.exception;

import com.bms.blog.dto.ResponseDto;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends SecurityException {
    private transient ResponseDto responseDto;

    private Object fieldValue;

    public BadRequestException(Object fieldValue) {
        super();
        this.fieldValue = fieldValue;
    }

    private void setApiResponse() {
        String message = String.format("%s 페이지 접근이 불가합니다.", fieldValue);
        responseDto = new ResponseDto(Boolean.FALSE, message);
    }
}
