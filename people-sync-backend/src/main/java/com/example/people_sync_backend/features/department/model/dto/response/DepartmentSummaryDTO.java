package com.example.people_sync_backend.features.department.model.dto.response;

import java.util.UUID;

public record DepartmentSummaryDTO(
        UUID id,
        String title) {

}
