package com.example.people_sync_backend.shared.interfaces;

import java.util.Collection;
import java.util.List;

public interface EntitySummaryConverter<E, S> {
    
    public S toSummaryDTO(E entity);

    public List<S> toSummaryListDTO(Collection<E> entityCollection);
}
