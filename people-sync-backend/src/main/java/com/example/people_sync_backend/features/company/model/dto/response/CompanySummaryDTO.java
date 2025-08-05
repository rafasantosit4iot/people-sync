package com.example.people_sync_backend.features.company.model.dto.response;

import java.util.UUID;

public record CompanySummaryDTO(
        UUID id,
        String name,
        Integer foundationYear) {

}
