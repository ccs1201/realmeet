package com.ccs.realmeet.infrastructure.mapper;


import java.util.Collection;
import java.util.stream.Collectors;

public interface MapperInterface<ENTITY, INPUTMODEL, RESPONSEMODEL> {

    ENTITY toEntity(INPUTMODEL inputmodel);

    RESPONSEMODEL toResponseModel(ENTITY entity);

    default Collection<RESPONSEMODEL> toResponseModelCollection(Collection<ENTITY> entityCollection){
        return entityCollection.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }

}
