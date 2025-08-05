package com.example.people_sync_backend.features.headquarter.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.headquarter.model.Headquarter;

public interface HeadquarterRepository extends JpaRepository<Headquarter, UUID>{
    
}
