package com.ccs.realmeet.domain.exception.service;

import com.ccs.realmeet.domain.exception.RealmeetException;

public class RealmeetServiceException extends RealmeetException {

    public RealmeetServiceException(String message) {
        super(message);
    }

    public RealmeetServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RealmeetServiceException(Throwable cause) {
        super(cause);
    }
}
