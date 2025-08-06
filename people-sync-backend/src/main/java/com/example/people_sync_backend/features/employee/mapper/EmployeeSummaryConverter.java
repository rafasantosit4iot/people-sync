package com.example.people_sync_backend.features.employee.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.employee.model.Employee;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class EmployeeSummaryConverter implements EntitySummaryConverter<Employee, EmployeeSummaryDTO> {

    @Override
    public EmployeeSummaryDTO toSummaryDTO(Employee employee) {
        return new EmployeeSummaryDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getContract(),
                employee.getRegister(),
                employee.isPcd(),
                employee.getBirthday(),
                employee.getGender(),
                employee.isActive(),
                employee.getCompany().getName(),
                employee.getRole().getName(),
                employee.getRole().getDepartment().getTitle());
    }

    @Override
    public List<EmployeeSummaryDTO> toSummaryListDTO(Collection<Employee> employees) {
        return employees.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
