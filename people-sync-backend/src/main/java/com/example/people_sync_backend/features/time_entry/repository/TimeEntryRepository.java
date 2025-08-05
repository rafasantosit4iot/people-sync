package com.example.people_sync_backend.features.time_entry.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.time_entry.model.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, UUID>{
    
}
