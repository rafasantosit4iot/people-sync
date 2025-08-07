package com.example.people_sync_backend.features.role.mapper;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.department.mapper.DepartmentSummaryConverter;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentSummaryDTO;
import com.example.people_sync_backend.features.employee.mapper.EmployeeSummaryConverter;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.role.model.Role;
import com.example.people_sync_backend.features.role.model.dto.request.RoleCreateDTO;
import com.example.people_sync_backend.features.role.model.dto.response.RoleResponseDTO;
import com.example.people_sync_backend.shared.classes.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleMapper extends EntityMapper<Role, RoleCreateDTO, RoleResponseDTO> {

    private final DepartmentSummaryConverter departmentSummaryConverter;
    private final EmployeeSummaryConverter employeeSummaryConverter;

    @Override
    public Role toEntity(RoleCreateDTO roleCreateDTO) {
        Role role = new Role();

        role.setName(roleCreateDTO.name());

        return role;
    }

    @Override
    public RoleResponseDTO toDTOResponse(Role role) {
        UUID id = role.getId();
        String name = role.getName();

        DepartmentSummaryDTO department = departmentSummaryConverter.toSummaryDTO(role.getDepartment());
        List<EmployeeSummaryDTO> employees = employeeSummaryConverter.toSummaryListDTO(role.getEmployees());

        return new RoleResponseDTO(id, name, department, employees);
    }
}
