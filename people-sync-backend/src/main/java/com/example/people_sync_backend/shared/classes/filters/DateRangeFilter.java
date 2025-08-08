package com.example.people_sync_backend.shared.classes.filters;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.example.people_sync_backend.shared.classes.GenericFilter;

import jakarta.persistence.criteria.Path;

public class DateRangeFilter<T> extends GenericFilter<T> {

    public DateRangeFilter(String field, String value) {
        super(field, value);
    }
    
    @Override
    protected Specification<T> createSpecification() {
        return (root, _, cb) -> {
            String[] dates = value.split("to");
            if(dates.length != 2) return null;

            Path<LocalDate> path = root.get(field);
            return cb.between(path, LocalDate.parse(dates[0]), LocalDate.parse(dates[1]));
        };
    }
}
