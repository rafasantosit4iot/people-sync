package com.example.people_sync_backend.features.role.model.dto.response;

import java.util.UUID;

public record RoleSummaryDTO(
        UUID id,
        String name,
        String departmentName) {

}
