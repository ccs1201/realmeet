package com.ccs.realmeet.domain.exception.security;

import com.ccs.realmeet.domain.exception.RealmeetException;

public class ApiValidationException extends RealmeetException {
    public ApiValidationException(String message) {
        super(message);
    }
}
