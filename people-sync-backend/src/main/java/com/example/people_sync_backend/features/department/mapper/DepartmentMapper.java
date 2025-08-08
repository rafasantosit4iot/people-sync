package com.example.people_sync_backend.features.department.mapper;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.mapper.CompanySummaryConverter;
import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.department.model.Department;
import com.example.people_sync_backend.features.department.model.dto.request.DepartmentCreateDTO;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentResponseDTO;
import com.example.people_sync_backend.features.role.mapper.RoleSummaryConverter;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;
import com.example.people_sync_backend.shared.classes.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentMapper extends EntityMapper<Department, DepartmentCreateDTO, DepartmentResponseDTO> {

    private final RoleSummaryConverter roleSummaryConverter;
    private final CompanySummaryConverter companySummaryConverter;

    @Override
    public Department toEntity(DepartmentCreateDTO departmentCreateDTO) {
        Department department = new Department();

        department.setName(departmentCreateDTO.name());
        
        return department;
    }

    @Override
    public DepartmentResponseDTO toDTOResponse(Department department) {
        UUID id = department.getId();
        String name = department.getName();

        List<RoleSummaryDTO> roles = roleSummaryConverter.toSummaryListDTO(department.getRoles());
        List<CompanySummaryDTO> companies = companySummaryConverter.toSummaryListDTO(department.getCompanies());

        return new DepartmentResponseDTO(id, name, roles, companies);
    }
}
