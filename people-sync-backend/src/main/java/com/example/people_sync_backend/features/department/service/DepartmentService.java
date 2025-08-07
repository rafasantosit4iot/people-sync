package com.example.people_sync_backend.features.department.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.department.mapper.DepartmentMapper;
import com.example.people_sync_backend.features.department.model.Department;
import com.example.people_sync_backend.features.department.model.dto.request.DepartmentCreateDTO;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentResponseDTO;
import com.example.people_sync_backend.features.department.repository.DepartmentRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

@Service
public class DepartmentService extends EntityService<Department, DepartmentCreateDTO, DepartmentResponseDTO, DepartmentRepository, DepartmentMapper> {

    public DepartmentService(DepartmentRepository entityRepository, DepartmentMapper entityMapper) {
        super(entityRepository, entityMapper);
    }
}
