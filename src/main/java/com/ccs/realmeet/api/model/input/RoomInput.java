package com.ccs.realmeet.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoomInput {

    @NotBlank
    @Size(max = 20)
    private String name;
    @Positive
    private int seats;
}
