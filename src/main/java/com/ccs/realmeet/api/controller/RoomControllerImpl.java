package com.ccs.realmeet.api.controller;

import com.ccs.realmeet.api.controller.interfaces.RoomController;
import com.ccs.realmeet.api.model.input.RoomInput;
import com.ccs.realmeet.api.model.response.RoomResponse;
import com.ccs.realmeet.domain.service.RoomService;
import com.ccs.realmeet.infrastructure.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/rooms")//, headers = "apikey")
@RequiredArgsConstructor
public class RoomControllerImpl implements RoomController {

    private final RoomService service;
    private final Executor threadPool;
    private final RoomMapper mapper;

    @Override
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<RoomResponse> save(@Valid @RequestBody RoomInput input, @RequestHeader String apikey) {
        return supplyAsync(() ->
                service.save(mapper.toEntity(input)), threadPool)
                .thenApply(mapper::toResponseModel);
    }

    //    @Override
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<RoomResponse> getById(@PathVariable @NotNull @Positive Long id, @Nullable @RequestHeader String apikey) {

        return supplyAsync(() ->
                service.findById(id), Executors.newVirtualThreadPerTaskExecutor())
                .thenApplyAsync(mapper::toResponseModel);
    }

    @Override
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<Collection<RoomResponse>> getAll(@RequestHeader @NotBlank String apikey) {

        return supplyAsync(service::findAll, threadPool)
                .thenApply(mapper::toResponseModelCollection);
    }

}
