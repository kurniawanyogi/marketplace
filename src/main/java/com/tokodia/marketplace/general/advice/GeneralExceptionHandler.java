package com.tokodia.marketplace.general.advice;

import com.tokodia.marketplace.general.exception.RegistrationException;
import com.tokodia.marketplace.general.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = RegistrationException.class)
    public ResponseEntity<BaseResponse> handleException(RegistrationException exception) {
        BaseResponse response = new BaseResponse();
        response.setCode("400-Validation");
        response.setDescription(exception.getMessage());
        response.setAdditionalEntity(null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
