package com.example.people_sync_backend.features.headquarter.model.dto.request;

import java.util.UUID;

public record HeadquarterCreateDTO(
        String city,
        String street,
        Integer number,
        UUID companyId,
        UUID countryId) {

}
