package com.example.people_sync_backend.features.project.model.dto.response;

import java.util.List;
import java.util.UUID;

import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntrySummaryDTO;

public record ProjectResponseDTO(
        UUID id,
        String name,
        String tag,
        String description,
        boolean finalized,
        List<EmployeeSummaryDTO> employees,
        List<TimeEntrySummaryDTO> timeEntries) {

}
