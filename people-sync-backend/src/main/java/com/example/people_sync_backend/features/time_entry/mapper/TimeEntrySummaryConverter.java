package com.example.people_sync_backend.features.time_entry.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.time_entry.model.TimeEntry;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntrySummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class TimeEntrySummaryConverter implements EntitySummaryConverter<TimeEntry, TimeEntrySummaryDTO>{
    
}
