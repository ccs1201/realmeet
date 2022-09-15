package com.ccs.realmeet.api.model.input;

import com.ccs.realmeet.api.model.input.ids.RoomIdInput;
import com.ccs.realmeet.domain.model.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.OffsetDateTime;

@Getter
@Setter
public class AllocationInput {


    private RoomIdInput room;

    @Valid
    @NotNull
    private Employee employee;

    @NotBlank
    @Size(max = 60)
    private String subject;

    @FutureOrPresent
    private OffsetDateTime startAt;

    @Future
    private OffsetDateTime endAt;
}
