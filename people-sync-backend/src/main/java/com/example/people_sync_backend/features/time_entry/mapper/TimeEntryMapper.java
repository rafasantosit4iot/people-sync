package com.example.people_sync_backend.features.time_entry.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.time_entry.model.TimeEntry;
import com.example.people_sync_backend.features.time_entry.model.dto.request.TimeEntryCreateDTO;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntryResponseDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

@Component
public class TimeEntryMapper implements EntityMapper<TimeEntry, TimeEntryCreateDTO, TimeEntryResponseDTO>{
    
}
