package com.ccs.realmeet.api.controller;

import com.ccs.realmeet.api.model.input.AllocationInput;
import com.ccs.realmeet.api.model.response.AllocationResponse;
import com.ccs.realmeet.domain.service.AllocationService;
import com.ccs.realmeet.infrastructure.mapper.AllocationMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping("/allocations")
public class AllocationController {


    private final Executor threadPool;
    private final AllocationService service;
    private final AllocationMapper mapper;

    public AllocationController(Executor threadPool, AllocationService service, AllocationMapper mapper) {
        this.threadPool = threadPool;
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/{roomId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Cria uma alocação de sala")
    public CompletableFuture<AllocationResponse> save(@RequestBody @Valid AllocationInput allocationInput) {
        return supplyAsync(
                () -> service.save(mapper.toEntity(allocationInput)), threadPool)
                .thenApplyAsync(mapper::toResponseModel);
    }

    @GetMapping("/{allocationId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Busca uma Alocação pelo ID", operationId = "operation id", method = "metodo",summary = "sumario")
    public CompletableFuture<AllocationResponse> getById(@PathVariable @Positive Long allocationId) {
        return supplyAsync(() ->
                service.findByID(allocationId))
                .thenApplyAsync(mapper::toResponseModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Retorna todas as alocações")
    public CompletableFuture<Collection<AllocationResponse>> getAll() {
        return supplyAsync(service::findAll)
                .thenApplyAsync(mapper::toResponseModelCollection);
    }
}
