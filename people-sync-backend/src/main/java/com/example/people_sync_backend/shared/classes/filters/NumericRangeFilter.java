package com.example.people_sync_backend.shared.classes.filters;

import org.springframework.data.jpa.domain.Specification;

import com.example.people_sync_backend.shared.classes.GenericFilter;

import jakarta.persistence.criteria.Path;

public class NumericRangeFilter<T> extends GenericFilter<T> {

    public NumericRangeFilter(String field, String value) {
        super(field, value);
    }

    @Override
    protected Specification<T> createSpecification() {
        return (var root, var _, var cb) -> {
            String[] range = value.split("to");
            if (range.length != 2)
                return null;

            Path<Double> path = root.get(field);
            Double xValue = Double.valueOf(range[0]);
            Double yValue = Double.valueOf(range[1]);

            return cb.between(path, xValue, yValue);
        };
    }
}
