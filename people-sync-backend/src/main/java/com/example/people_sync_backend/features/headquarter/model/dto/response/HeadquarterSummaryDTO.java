package com.example.people_sync_backend.features.headquarter.model.dto.response;

import java.util.UUID;

public record HeadquarterSummaryDTO(
        UUID id,
        String city,
        String street,
        Integer number,
        String country,
        String companyName) {

}
