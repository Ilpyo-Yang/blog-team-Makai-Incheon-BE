package com.bms.blog.exception;

import com.bms.blog.dto.ResponseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private transient ResponseDto responseDto;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super();
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    private void setApiResponse() {
        String message = String.format("%s 에서 %s 값이 '%s' 인 데이터가 없습니다.", resourceName, fieldName, fieldValue);
        responseDto = new ResponseDto(Boolean.FALSE, message);
    }
}
