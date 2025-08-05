package com.example.people_sync_backend.features.headquarter.model.dto.request;

import org.hibernate.validator.constraints.UUID;

public record HeadquarterCreateDTO(
        String city,
        String street,
        Integer number,
        UUID companyID,
        UUID countryId) {

}
