package com.example.people_sync_backend.features.department.model.dto.response;

import java.util.List;
import java.util.UUID;

import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;

public record DepartmentResponseDTO(
        UUID id,
        String title,
        List<RoleSummaryDTO> roles,
        List<CompanySummaryDTO> companies) {

}
