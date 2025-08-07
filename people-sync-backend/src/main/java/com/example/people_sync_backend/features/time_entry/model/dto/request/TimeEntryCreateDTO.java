package com.example.people_sync_backend.features.time_entry.model.dto.request;

import java.security.Timestamp;

import org.hibernate.validator.constraints.UUID;

public record TimeEntryCreateDTO(
        Timestamp openTimestamp,
        Timestamp closeTimestamp,
        String description,
        UUID employeeId,
        UUID projectId) {
}
