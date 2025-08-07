package com.example.people_sync_backend.features.project.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.project.model.Project;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectSummaryDTO;
import com.example.people_sync_backend.shared.classes.EntitySummaryConverter;

@Component
public class ProjectSummaryConverter extends EntitySummaryConverter<Project, ProjectSummaryDTO> {

    @Override
    public ProjectSummaryDTO toSummaryDTO(Project project) {
        return new ProjectSummaryDTO(
                project.getId(),
                project.getName(),
                project.getTag(),
                project.getDescription(),
                project.isFinalized());
    }
}
