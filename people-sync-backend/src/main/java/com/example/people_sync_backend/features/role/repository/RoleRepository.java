package com.example.people_sync_backend.features.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.role.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
