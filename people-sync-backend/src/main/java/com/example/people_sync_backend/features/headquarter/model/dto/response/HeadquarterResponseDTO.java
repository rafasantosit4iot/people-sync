package com.example.people_sync_backend.features.headquarter.model.dto.response;

import java.util.UUID;

import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.country.model.dto.response.CountrySummaryDTO;

public record HeadquarterResponseDTO(
        UUID id,
        String city,
        String street,
        Integer number,
        CompanySummaryDTO company,
        CountrySummaryDTO country) {

}
