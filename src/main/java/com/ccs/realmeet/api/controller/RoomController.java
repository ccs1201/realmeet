package com.ccs.realmeet.api.controller;

import com.ccs.realmeet.api.model.input.RoomInput;
import com.ccs.realmeet.api.model.response.RoomResponse;
import com.ccs.realmeet.domain.service.RoomService;
import com.ccs.realmeet.infrastructure.mapper.RoomMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;
    private final Executor threadPool;

    private final RoomMapper mapper;

    public RoomController(RoomService service, Executor threadPool, RoomMapper roomMapper) {
        this.service = service;
        this.threadPool = threadPool;
        this.mapper = roomMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<RoomResponse> save(@Valid @RequestBody RoomInput input) {
        return supplyAsync(() ->
                service.save(mapper.toEntity(input)), threadPool)
                .thenApply(mapper::toResponseModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<RoomResponse> getById(@PathVariable @NotNull @Positive Long id) {
        return supplyAsync(() ->
                service.findById(id), threadPool)
                .thenApply(mapper::toResponseModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<Collection<RoomResponse>> getAll() {
        return supplyAsync(service::findAll, threadPool)
                .thenApply(mapper::toResponseModelCollection);
    }

}
