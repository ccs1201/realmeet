package com.ccs.realmeet.domain.service;

import com.ccs.realmeet.domain.entity.Allocation;
import com.ccs.realmeet.domain.exception.service.allocation.AllocationNotFoundException;
import com.ccs.realmeet.domain.repository.AllocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AllocationService {

    private final AllocationRepository repository;
    private final RoomService roomService;

    public AllocationService(AllocationRepository repository, RoomService roomService) {
        this.repository = repository;
        this.roomService = roomService;
    }

    public Allocation save(Allocation allocation) {
        var room = roomService.findById(allocation.getRoom().getId());

        allocation.getRoom().setId(room.getId());

        return repository.save(allocation);
    }

    public Allocation findByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new AllocationNotFoundException(String.format("Allocation ID: %d não encontrado.", id), "Allocation"));
    }

    public Allocation update(Long id, Allocation allocation) {

        var allocationFromDB = this.findByID(id);

        BeanUtils.copyProperties(allocation, allocationFromDB);

        return repository.saveAndFlush(allocationFromDB);

    }

    public void delete(Long id) {
        this.findByID(id);
        repository.deleteById(id);
    }

    public Collection<Allocation> findAll() {
        return repository.findAllEager();
    }
}
