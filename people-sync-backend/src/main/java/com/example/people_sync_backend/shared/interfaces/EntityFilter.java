package com.example.people_sync_backend.shared.interfaces;

import org.springframework.data.jpa.domain.Specification;

public interface EntityFilter<T> {
    Specification<T> toSpecification();
}
