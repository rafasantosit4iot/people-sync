package com.example.people_sync_backend.features.company.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID>{
    
}
