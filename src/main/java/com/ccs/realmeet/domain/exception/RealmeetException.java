package com.ccs.realmeet.domain.exception;

public class RealmeetException extends RuntimeException {

    public RealmeetException(String message) {
        super(message);
    }

    public RealmeetException(String message, Throwable cause) {
        super(message, cause);
    }

    public RealmeetException(Throwable cause) {
        super(cause);
    }
}
