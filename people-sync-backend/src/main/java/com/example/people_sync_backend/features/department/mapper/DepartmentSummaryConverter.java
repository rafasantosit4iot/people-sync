package com.example.people_sync_backend.features.department.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.department.model.Department;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class DepartmentSummaryConverter implements EntitySummaryConverter<Department, DepartmentSummaryDTO> {
    @Override
    public DepartmentSummaryDTO toSummaryDTO(Department department) {
        return new DepartmentSummaryDTO(
                department.getId(),
                department.getTitle());
    }

    @Override
    public List<DepartmentSummaryDTO> toSummaryListDTO(Collection<Department> departments) {
        return departments.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
