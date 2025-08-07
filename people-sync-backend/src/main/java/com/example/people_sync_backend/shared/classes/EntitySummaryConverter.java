package com.example.people_sync_backend.shared.classes;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntitySummaryConverter<BaseEntity, SummaryEntity> {

    public abstract SummaryEntity toSummaryDTO(BaseEntity entity);

    public List<SummaryEntity> toSummaryListDTO(Collection<BaseEntity> entityCollection) {
        return entityCollection.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
