package com.tokodia.marketplace.general.exception;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private String code;
    private String message;

    public GeneralException(String code, String errorMessage) {
        this.code = code;
        this.message = errorMessage;
    }
}
