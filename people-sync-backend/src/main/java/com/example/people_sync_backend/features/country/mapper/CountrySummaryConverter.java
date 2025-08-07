package com.example.people_sync_backend.features.country.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.country.model.Country;
import com.example.people_sync_backend.features.country.model.dto.response.CountrySummaryDTO;
import com.example.people_sync_backend.shared.classes.EntitySummaryConverter;

@Component
public class CountrySummaryConverter extends EntitySummaryConverter<Country, CountrySummaryDTO> {

    @Override
    public CountrySummaryDTO toSummaryDTO(Country country) {
        return new CountrySummaryDTO(
                country.getId(),
                country.getName());
    }
}
