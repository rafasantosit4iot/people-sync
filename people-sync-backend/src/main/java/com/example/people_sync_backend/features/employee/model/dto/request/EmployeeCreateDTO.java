package com.example.people_sync_backend.features.employee.model.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UUID;

import com.example.people_sync_backend.features.employee.model.enums.ContractType;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeGender;

public record EmployeeCreateDTO(
                String name,
                String email,
                ContractType contract,
                String register,
                String password,
                boolean pcd,
                LocalDate birthday,
                EmployeeGender gender,
                boolean active,
                UUID companyId,
                UUID roleId) {

}
