package com.ccs.realmeet.api.model.response;

import com.ccs.realmeet.api.model.input.RoomInput;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public final class RoomResponse extends RoomInput {
    @JsonProperty(index = 20)
    private Long id;

    private Boolean active;

    private OffsetDateTime createTimeStamp;

    private OffsetDateTime lastUpdate;
}
