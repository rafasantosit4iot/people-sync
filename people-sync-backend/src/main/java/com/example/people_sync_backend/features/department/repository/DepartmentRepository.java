package com.example.people_sync_backend.features.department.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.department.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, UUID>{
    
}
