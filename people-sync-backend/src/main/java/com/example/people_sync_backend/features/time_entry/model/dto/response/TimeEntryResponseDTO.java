package com.example.people_sync_backend.features.time_entry.model.dto.response;

import java.security.Timestamp;

import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectSummaryDTO;

public record TimeEntryResponseDTO(
        Timestamp entryTimestamp,
        Timestamp closeTimestamp,
        String description,
        EmployeeSummaryDTO employee,
        ProjectSummaryDTO project) {

}
