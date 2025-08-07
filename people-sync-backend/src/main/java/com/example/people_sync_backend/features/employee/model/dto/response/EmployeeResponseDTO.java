package com.example.people_sync_backend.features.employee.model.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.employee.model.enums.ContractType;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeGender;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectSummaryDTO;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntrySummaryDTO;

public record EmployeeResponseDTO(
        UUID id,
        String name,
        String email,
        ContractType contract,
        String register,
        boolean pcd,
        LocalDate birthday,
        EmployeeGender gender,
        boolean active,
        CompanySummaryDTO company,
        RoleSummaryDTO role,
        List<ProjectSummaryDTO> projects,
                        List<TimeEntrySummaryDTO> timeEntries) {

}
