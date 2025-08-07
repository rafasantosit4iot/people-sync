package com.example.people_sync_backend.features.project.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.project.model.Project;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class ProjectSummaryConverter implements EntitySummaryConverter<Project, ProjectSummaryDTO> {

    @Override
    public ProjectSummaryDTO toSummaryDTO(Project project) {
        return new ProjectSummaryDTO(
                project.getId(),
                project.getName(),
                project.getTag(),
                project.getDescription(),
                project.isFinalized());
    }

    @Override
    public List<ProjectSummaryDTO> toSummaryListDTO(Collection<Project> projects) {
        return projects.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
