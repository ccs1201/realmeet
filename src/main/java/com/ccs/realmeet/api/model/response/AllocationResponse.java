package com.ccs.realmeet.api.model.response;

import com.ccs.realmeet.domain.entity.Room;
import com.ccs.realmeet.domain.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllocationResponse {

    private Long id;

    @JsonIgnoreProperties({"createTimeStamp", "lastUpdate", "active"})
    private Room room;

    private Employee employee;

    private String subject;

    private OffsetDateTime startAt;

    private OffsetDateTime endAt;

    private OffsetDateTime createdAt;

    private OffsetDateTime updateAt;

}
