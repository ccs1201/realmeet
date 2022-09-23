package com.ccs.realmeet.api.controller.interfaces;

import com.ccs.realmeet.api.model.input.RoomInput;
import com.ccs.realmeet.api.model.response.RoomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public interface RoomController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CompletableFuture<RoomResponse> save(@Valid @RequestBody RoomInput input, @RequestHeader String apikey);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CompletableFuture<RoomResponse> getById(@PathVariable @NotNull @Positive Long id, @RequestHeader String apikey);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    CompletableFuture<Collection<RoomResponse>> getAll(@RequestHeader @NotBlank String apikey);
}
