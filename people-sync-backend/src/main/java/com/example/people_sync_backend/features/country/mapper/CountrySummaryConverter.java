package com.example.people_sync_backend.features.country.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.country.model.Country;
import com.example.people_sync_backend.features.country.model.dto.response.CountrySummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class CountrySummaryConverter implements EntitySummaryConverter<Country, CountrySummaryDTO> {

    @Override
    public CountrySummaryDTO toSummaryDTO(Country country) {
        return new CountrySummaryDTO(
                country.getId(),
                country.getName());
    }

    @Override
    public List<CountrySummaryDTO> toSummaryListDTO(Collection<Country> countries) {
        return countries.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
