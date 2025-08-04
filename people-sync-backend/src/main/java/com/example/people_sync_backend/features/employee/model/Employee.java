package com.example.people_sync_backend.features.employee.model;

import java.util.UUID;

import com.example.people_sync_backend.features.employee.model.enums.ContractType;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeRole;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee {
    @Id
    private UUID id;

    @Column(length=40)
    private String name;

    @Column(unique=true)
    private String email;

    private EmployeeRole role;
    private ContractType contract;

    @Column(unique=true)
    private String register;

    private EmployeeType type;
}
