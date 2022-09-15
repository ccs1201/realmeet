package com.ccs.realmeet.domain.exception.service;

import lombok.Getter;

@Getter
public class RealmeetEntityNotFoundException extends RealmeetServiceException {

    private final String entityName;

    public RealmeetEntityNotFoundException(String message, String entityName) {
        super(message);
        this.entityName = entityName;
    }

    public RealmeetEntityNotFoundException(String message, Throwable cause, String entityName) {
        super(message, cause);
        this.entityName = entityName;
    }

    public RealmeetEntityNotFoundException(Throwable cause, String entityName) {
        super(cause);
        this.entityName = entityName;
    }
}
