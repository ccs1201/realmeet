package com.ccs.realmeet.domain.repository;

import com.ccs.realmeet.domain.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {

    @Override
    @Query("from Allocation al join fetch al.room where al.id = :id")
    Optional<Allocation> findById(Long id);


    @Query("from Allocation al join fetch al.room")
    Collection<Allocation> findAllEager();
}
