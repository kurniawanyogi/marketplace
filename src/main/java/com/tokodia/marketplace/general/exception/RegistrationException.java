package com.tokodia.marketplace.general.exception;

import lombok.Getter;

@Getter
public class RegistrationException extends RuntimeException {
    private String message;

    public RegistrationException(String errorMessage) {
        this.message = errorMessage;
    }
}
