package com.ccs.realmeet.domain.service;

import com.ccs.realmeet.domain.entity.Room;
import com.ccs.realmeet.domain.exception.service.RealmeetServiceException;
import com.ccs.realmeet.domain.exception.service.Room.RoomNotFoundException;
import com.ccs.realmeet.domain.repository.RoomRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoomService {
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    private final RoomRepository repository;

    public Room save(Room room) {
        try {
            return repository.save(room);
        } catch (DataIntegrityViolationException e) {
            throw new RealmeetServiceException(
                    String.format("Não foi possível salvar o Room. %s já existe.", room.getName()), e);
        }
    }

    public Room findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RoomNotFoundException(String.format("Room ID: %d não localizado.", id), "Room"));
    }

    public Collection<Room> findAll() {
        return repository.findAll();
    }
}
