package com.example.people_sync_backend.shared.classes.filters;

import org.springframework.data.jpa.domain.Specification;

import com.example.people_sync_backend.shared.classes.GenericFilter;

import jakarta.persistence.criteria.Path;

public class TextFilter<T> extends GenericFilter<T>{

    public TextFilter(String field, String value) {
        super(field, value);
    }
    
    @Override
    protected Specification<T> createSpecification() {
        return (root, _, cb) -> {
            Path<String> path = root.get(value);
            return cb.like(cb.lower(path), "%" + value.toLowerCase() + "%");
        };
    }
}
