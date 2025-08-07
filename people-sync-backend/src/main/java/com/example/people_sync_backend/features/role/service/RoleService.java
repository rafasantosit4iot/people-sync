package com.example.people_sync_backend.features.role.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.department.model.Department;
import com.example.people_sync_backend.features.department.repository.DepartmentRepository;
import com.example.people_sync_backend.features.role.mapper.RoleMapper;
import com.example.people_sync_backend.features.role.model.Role;
import com.example.people_sync_backend.features.role.model.dto.request.RoleCreateDTO;
import com.example.people_sync_backend.features.role.model.dto.response.RoleResponseDTO;
import com.example.people_sync_backend.features.role.repository.RoleRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoleService extends EntityService<Role, RoleCreateDTO, RoleResponseDTO, RoleRepository, RoleMapper> {

    private final DepartmentRepository departmentRepository;

    public RoleService(RoleRepository entityRepository, RoleMapper entityMapper,
            DepartmentRepository departmentRepository) {
        super(entityRepository, entityMapper);
        this.departmentRepository = departmentRepository;
    }

    @Override
    public RoleResponseDTO createEntity(RoleCreateDTO roleCreateDTO) {
        Role role = entityMapper.toEntity(roleCreateDTO);
        role = entityRepository.save(role);
        role = validateBeforeSave(role, roleCreateDTO);
        
        return entityMapper.toDTOResponse(role);
    }

    @Override
    public Role validateBeforeSave(Role role, RoleCreateDTO roleCreateDTO) {
        Department department = departmentRepository.findById(roleCreateDTO.departmentId())
                .orElseThrow(() -> new EntityNotFoundException("Departamento não encontrado"));

        role.setDepartment(department);
        return role;
    }
}
