package com.stussy.stussyclone20220930leeyw.api.advice;

import com.stussy.stussyclone20220930leeyw.dto.CMRespDto;
import com.stussy.stussyclone20220930leeyw.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220930leeyw.exception.CustomValidationException;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationErrorException(CustomValidationException e){

        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(),e.getErrorMap()));
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<?> CustomInternalServerErrorException(CustomInternalServerErrorException e){

        return ResponseEntity.internalServerError().body(new CMRespDto<>(e.getMessage(), null ));
    }

}
