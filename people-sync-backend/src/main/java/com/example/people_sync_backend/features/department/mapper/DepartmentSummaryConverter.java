package com.example.people_sync_backend.features.department.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.department.model.Department;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentSummaryDTO;
import com.example.people_sync_backend.shared.classes.EntitySummaryConverter;

@Component
public class DepartmentSummaryConverter extends EntitySummaryConverter<Department, DepartmentSummaryDTO> {
    @Override
    public DepartmentSummaryDTO toSummaryDTO(Department department) {
        return new DepartmentSummaryDTO(
                department.getId(),
                department.getTitle());
    }
}
