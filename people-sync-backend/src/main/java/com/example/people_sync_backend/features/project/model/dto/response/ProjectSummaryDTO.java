package com.example.people_sync_backend.features.project.model.dto.response;

import java.util.UUID;

public record ProjectSummaryDTO(
        UUID id,
        String name,
        String tag,
        String description,
        boolean finalized
) {
    
}
