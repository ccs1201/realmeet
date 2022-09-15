package com.ccs.realmeet.domain.exception.service.allocation;

import com.ccs.realmeet.domain.exception.service.RealmeetEntityNotFoundException;

public class AllocationNotFoundException extends RealmeetEntityNotFoundException {
    public AllocationNotFoundException(String message, String entityName) {
        super(message, entityName);
    }
}
