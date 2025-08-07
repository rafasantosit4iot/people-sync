package com.example.people_sync_backend.features.time_entry.mapper;

import java.security.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.employee.mapper.EmployeeSummaryConverter;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.project.mapper.ProjectSummaryConverter;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectSummaryDTO;
import com.example.people_sync_backend.features.time_entry.model.TimeEntry;
import com.example.people_sync_backend.features.time_entry.model.dto.request.TimeEntryCreateDTO;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntryResponseDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TimeEntryMapper implements EntityMapper<TimeEntry, TimeEntryCreateDTO, TimeEntryResponseDTO> {

    private final EmployeeSummaryConverter employeeSummaryConverter;
    private final ProjectSummaryConverter projectSummaryConverter;

    @Override
    public TimeEntry toEntity(TimeEntryCreateDTO timeEntryCreateDTO) {
        TimeEntry timeEntry = new TimeEntry();

        timeEntry.setOpenTimestamp(timeEntryCreateDTO.openTimestamp());
        timeEntry.setCloseTimestamp(timeEntryCreateDTO.closeTimestamp());
        timeEntry.setDescription(timeEntryCreateDTO.description());

        timeEntry.setEmployee(employee);
        timeEntry.setProject(project);

        return timeEntry;
    }

    @Override
    public TimeEntryResponseDTO toDTOResponse(TimeEntry timeEntry) {
        Timestamp openTimestamp = timeEntry.getOpenTimestamp();
        Timestamp closeTimestamp = timeEntry.getCloseTimestamp();
        String description = timeEntry.getDescription();

        EmployeeSummaryDTO employee = employeeSummaryConverter.toSummaryDTO(timeEntry.getEmployee());
        ProjectSummaryDTO project = projectSummaryConverter.toSummaryDTO(timeEntry.getProject());

        return new TimeEntryResponseDTO(openTimestamp, closeTimestamp, description, employee, project);
    }

    @Override
    public Page<TimeEntryResponseDTO> toDTOPageResponse(Page<TimeEntry> timeEntries) {
        return timeEntries.map(this::toDTOResponse);
    }

    @Override
    public List<TimeEntryResponseDTO> toDTOListResponse(Collection<TimeEntry> timeEntries) {
        return timeEntries.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
