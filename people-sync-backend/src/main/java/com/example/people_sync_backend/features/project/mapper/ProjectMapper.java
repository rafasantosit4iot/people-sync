package com.example.people_sync_backend.features.project.mapper;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.employee.mapper.EmployeeSummaryConverter;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.project.model.Project;
import com.example.people_sync_backend.features.project.model.dto.request.ProjectCreateDTO;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectResponseDTO;
import com.example.people_sync_backend.features.time_entry.mapper.TimeEntrySummaryConverter;
import com.example.people_sync_backend.features.time_entry.model.dto.response.TimeEntrySummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectMapper implements EntityMapper<Project, ProjectCreateDTO, ProjectResponseDTO> {

    private final EmployeeSummaryConverter employeeSummaryConverter;
    private final TimeEntrySummaryConverter timeEntrySummaryConverter;

    @Override
    public Project toEntity(ProjectCreateDTO projectCreateDTO) {
        Project project = new Project();

        project.setName(projectCreateDTO.name());
        project.setTag(projectCreateDTO.tag());
        project.setDescription(projectCreateDTO.description());

        return project;
    }

    @Override
    public ProjectResponseDTO toDTOResponse(Project project) {
        UUID id = project.getId();
        String name = project.getName();
        String tag = project.getTag();
        String description = project.getDescription();
        boolean finalized = project.isFinalized();

        List<EmployeeSummaryDTO> employees = employeeSummaryConverter.toSummaryListDTO(project.getEmployees());
        List<TimeEntrySummaryDTO> timeEntries = timeEntrySummaryConverter.toSummaryListDTO(project.getTimeEntries());

        return new ProjectResponseDTO(id, name, tag, description, finalized, employees, timeEntries);
    }

    @Override
    public Page<ProjectResponseDTO> toDTOPageResponse(Page<Project> projects) {
        return projects.map(this::toDTOResponse);
    }

    @Override
    public List<ProjectResponseDTO> toDTOListResponse(Collection<Project> projects) {
        return projects.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
