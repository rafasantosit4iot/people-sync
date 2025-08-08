package com.example.people_sync_backend.shared.classes;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public abstract class EntityMapper<Base, Create, Response> {

    public abstract Base toEntity(Create entityDTO);

    public abstract Response toDTOResponse(Base entity);

    public Page<Response> toDTOPageResponse(Page<Base> entityPage) {
        return entityPage.map(this::toDTOResponse);
    }

    public List<Response> toDTOListResponse(Collection<Base> entityCollection) {
        return entityCollection.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
