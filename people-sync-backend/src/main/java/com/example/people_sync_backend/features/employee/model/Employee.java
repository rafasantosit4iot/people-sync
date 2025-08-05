package com.example.people_sync_backend.features.employee.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.management.relation.Role;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.employee.model.enums.ContractType;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeGender;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private ContractType contract;

    @Column(unique = true, nullable = false)
    private String register;

    @Column(nullable = false)
    private EmployeeType type;

    @Column(unique = true)
    private String password;

    @Column(nullable = false)
    private boolean pcd;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private EmployeeGender gender;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;
}
