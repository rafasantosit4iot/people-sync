package com.example.people_sync_backend.shared.interfaces;

import java.util.List;

import org.springframework.util.MultiValueMap;

public interface FilterParser<T>{
    public List<EntityFilter<T>> parseFilters(MultiValueMap<String, String> params);
}
