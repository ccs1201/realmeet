package com.ccs.realmeet.infrastructure.mapper;

import com.ccs.realmeet.api.model.input.RoomInput;
import com.ccs.realmeet.api.model.response.RoomResponse;
import com.ccs.realmeet.domain.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends MapperInterface<Room, RoomInput, RoomResponse> {

}
