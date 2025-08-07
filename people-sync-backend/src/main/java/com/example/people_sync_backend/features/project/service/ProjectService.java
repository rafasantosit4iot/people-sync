package com.example.people_sync_backend.features.project.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.project.mapper.ProjectMapper;
import com.example.people_sync_backend.features.project.model.Project;
import com.example.people_sync_backend.features.project.model.dto.request.ProjectCreateDTO;
import com.example.people_sync_backend.features.project.model.dto.response.ProjectResponseDTO;
import com.example.people_sync_backend.features.project.repository.ProjectRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

@Service
public class ProjectService extends EntityService<Project, ProjectCreateDTO, ProjectResponseDTO, ProjectRepository, ProjectMapper> {

    public ProjectService(ProjectRepository entityRepository, ProjectMapper entityMapper) {
        super(entityRepository, entityMapper);
    }

    @Override
    public ProjectResponseDTO createEntity(ProjectCreateDTO projectCreateDTO) {
        Project project = entityMapper.toEntity(projectCreateDTO);

        project.setFinalized(false);
        project = entityRepository.save(project);

        return entityMapper.toDTOResponse(project);
    }
}
