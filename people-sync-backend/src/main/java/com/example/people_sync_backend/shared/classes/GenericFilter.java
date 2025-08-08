package com.example.people_sync_backend.shared.classes;

import org.springframework.data.jpa.domain.Specification;

import com.example.people_sync_backend.shared.interfaces.EntityFilter;

public abstract class GenericFilter<T> implements EntityFilter<T> {
    protected final String field;
    protected final String value;

    protected GenericFilter(String field, String value) {
        this.field = field;
        this.value = value;
    }

    protected abstract Specification<T> createSpecification();

    @Override
    public Specification<T> toSpecification() {
        return createSpecification();
    }
}
