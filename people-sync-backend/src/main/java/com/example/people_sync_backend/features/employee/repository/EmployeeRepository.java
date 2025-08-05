package com.example.people_sync_backend.features.employee.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
