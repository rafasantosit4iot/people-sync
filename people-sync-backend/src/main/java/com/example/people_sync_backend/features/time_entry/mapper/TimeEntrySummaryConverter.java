package com.example.people_sync_backend.features.time_entry.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.time_entry.model.TimeEntry;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntrySummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class TimeEntrySummaryConverter implements EntitySummaryConverter<TimeEntry, TimeEntrySummaryDTO> {

    @Override
    public TimeEntrySummaryDTO toSummaryDTO(TimeEntry timeEntry) {
        return new TimeEntrySummaryDTO(
                timeEntry.getOpenTimestamp(),
                timeEntry.getCloseTimestamp(),
                timeEntry.getDescription(),
                timeEntry.getEmployee().getId(),
                timeEntry.getEmployee().getName(),
                timeEntry.getProject().getId(),
                timeEntry.getProject().getName());
    }

    @Override
    public List<TimeEntrySummaryDTO> toSummaryListDTO(Collection<TimeEntry> timeEntries) {
        return timeEntries.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
