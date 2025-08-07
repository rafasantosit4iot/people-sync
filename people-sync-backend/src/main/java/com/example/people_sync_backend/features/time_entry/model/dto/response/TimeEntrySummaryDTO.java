package com.example.people_sync_backend.features.time_entry.model.dto.response;

import java.security.Timestamp;
import java.util.UUID;

public record TimeEntrySummaryDTO(
        Timestamp openTimestamp,
        Timestamp closeTimestamp,
        String description,
        UUID employeeId,
        String employeeName,
        UUID projectId,
        String projectName) {

}
