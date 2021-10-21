package com.jaya.challenge.api.currency.converter.exception;

public class CurrencyNotSupportedException extends RuntimeException {

    public CurrencyNotSupportedException() {
        super();
    }

    public CurrencyNotSupportedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CurrencyNotSupportedException(final String message) {
        super(message);
    }

    public CurrencyNotSupportedException(final Throwable cause) {
        super(cause);
    }
}
