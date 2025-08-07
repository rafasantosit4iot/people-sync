package com.example.people_sync_backend.features.time_entry.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.employee.model.Employee;
import com.example.people_sync_backend.features.employee.repository.EmployeeRepository;
import com.example.people_sync_backend.features.project.model.Project;
import com.example.people_sync_backend.features.project.repository.ProjectRepository;
import com.example.people_sync_backend.features.time_entry.mapper.TimeEntryMapper;
import com.example.people_sync_backend.features.time_entry.model.TimeEntry;
import com.example.people_sync_backend.features.time_entry.model.dto.request.TimeEntryCreateDTO;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntryResponseDTO;
import com.example.people_sync_backend.features.time_entry.repository.TimeEntryRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TimeEntryService extends
        EntityService<TimeEntry, TimeEntryCreateDTO, TimeEntryResponseDTO, TimeEntryRepository, TimeEntryMapper> {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public TimeEntryService(EmployeeRepository employeeRepository, ProjectRepository projectRepository,
            TimeEntryRepository entityRepository, TimeEntryMapper entityMapper) {
        super(entityRepository, entityMapper);
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public TimeEntryResponseDTO createEntity(TimeEntryCreateDTO timeEntryCreateDTO) {
        TimeEntry timeEntry = entityMapper.toEntity(timeEntryCreateDTO);
        timeEntry = validateBeforeSave(timeEntry, timeEntryCreateDTO);
        timeEntry = entityRepository.save(timeEntry);

        return entityMapper.toDTOResponse(timeEntry);
    }

    @Override
    public TimeEntry validateBeforeSave(TimeEntry timeEntry, TimeEntryCreateDTO timeEntryCreateDTO) {
        Employee employee = employeeRepository.findById(timeEntryCreateDTO.employeeId())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));

        Project project = projectRepository.findById(timeEntryCreateDTO.projectId())
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));

        timeEntry.setEmployee(employee);
        timeEntry.setProject(project);

        return timeEntry;
    }
}
