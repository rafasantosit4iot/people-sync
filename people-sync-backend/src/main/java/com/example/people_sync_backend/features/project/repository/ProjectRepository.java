package com.example.people_sync_backend.features.project.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.project.model.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID>{
    
}
