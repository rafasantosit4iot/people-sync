package com.example.people_sync_backend.shared.classes;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public abstract class EntityMapper<Entity, CreateEntity, ResponseEntity> {

    public abstract Entity toEntity(CreateEntity entityDTO);

    public abstract ResponseEntity toDTOResponse(Entity entity);

    public Page<ResponseEntity> toDTOPageResponse(Page<Entity> entityPage) {
        return entityPage.map(this::toDTOResponse);
    }

    public List<ResponseEntity> toDTOListResponse(Collection<Entity> entityCollection) {
        return entityCollection.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
