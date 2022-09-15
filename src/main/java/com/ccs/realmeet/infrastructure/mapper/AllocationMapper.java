package com.ccs.realmeet.infrastructure.mapper;

import com.ccs.realmeet.api.model.input.AllocationInput;
import com.ccs.realmeet.api.model.response.AllocationResponse;
import com.ccs.realmeet.domain.entity.Allocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AllocationMapper extends MapperInterface<Allocation, AllocationInput, AllocationResponse> {
}
