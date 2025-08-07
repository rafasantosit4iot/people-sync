package com.example.people_sync_backend.features.company.model.dto.response;

import java.util.List;
import java.util.UUID;

import com.example.people_sync_backend.features.department.model.dto.response.DepartmentSummaryDTO;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterSummaryDTO;

public record CompanyResponseDTO(
                UUID id,
                String name,
                Integer foundationYear,
                List<HeadquarterSummaryDTO> headquarters,
                List<EmployeeSummaryDTO> employees,
                List<DepartmentSummaryDTO> departments) {

}
