package com.ccs.realmeet.domain.exception.service.Room;

import com.ccs.realmeet.domain.exception.service.RealmeetEntityNotFoundException;

public class RoomNotFoundException extends RealmeetEntityNotFoundException {

    public RoomNotFoundException(String message, String entityName) {
        super(message, entityName);
    }
}
