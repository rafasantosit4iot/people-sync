package com.example.people_sync_backend.features.role.model.dto.response;

import java.util.List;
import java.util.UUID;

import com.example.people_sync_backend.features.department.model.dto.response.DepartmentSummaryDTO;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;

public record RoleResponseDTO(
        UUID id,
        String name,
        DepartmentSummaryDTO department,
        List<EmployeeSummaryDTO> employees) {

}
