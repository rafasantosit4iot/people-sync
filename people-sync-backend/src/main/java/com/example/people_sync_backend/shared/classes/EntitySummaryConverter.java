package com.example.people_sync_backend.shared.classes;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntitySummaryConverter<Base, Summary> {

    public abstract Summary toSummaryDTO(Base entity);

    public List<Summary> toSummaryListDTO(Collection<Base> entityCollection) {
        return entityCollection.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
