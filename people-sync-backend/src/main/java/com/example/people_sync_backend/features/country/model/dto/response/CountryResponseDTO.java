package com.example.people_sync_backend.features.country.model.dto.response;

import java.util.UUID;

public record CountryResponseDTO(
        UUID id,
        String name,
        String isoCode) {

}
