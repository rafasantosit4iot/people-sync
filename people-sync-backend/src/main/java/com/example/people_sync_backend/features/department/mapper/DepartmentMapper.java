package com.example.people_sync_backend.features.department.mapper;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.mapper.CompanySummaryConverter;
import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.department.model.Department;
import com.example.people_sync_backend.features.department.model.dto.request.DepartmentCreateDTO;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentResponseDTO;
import com.example.people_sync_backend.features.role.mapper.RoleSummaryConverter;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentMapper implements EntityMapper<Department, DepartmentCreateDTO, DepartmentResponseDTO> {

    private final RoleSummaryConverter roleSummaryConverter;
    private final CompanySummaryConverter companySummaryConverter;

    @Override
    public Department toEntity(DepartmentCreateDTO departmentCreateDTO) {
        Department department = new Department();

        department.setTitle(departmentCreateDTO.title());
        
        return department;
    }

    @Override
    public DepartmentResponseDTO toDTOResponse(Department department) {
        UUID id = department.getId();
        String title = department.getTitle();

        List<RoleSummaryDTO> roles = roleSummaryConverter.toSummaryListDTO(department.getRoles());
        List<CompanySummaryDTO> companies = companySummaryConverter.toSummaryListDTO(department.getCompanies());

        return new DepartmentResponseDTO(id, title, roles, companies);
    }

    @Override
    public Page<DepartmentResponseDTO> toDTOPageResponse(Page<Department> departments) {
        return departments.map(this::toDTOResponse);
    }

    @Override
    public List<DepartmentResponseDTO> toDTOListResponse(Collection<Department> departments) {
        return departments.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
