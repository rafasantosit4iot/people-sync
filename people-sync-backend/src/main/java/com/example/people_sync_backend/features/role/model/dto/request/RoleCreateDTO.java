package com.example.people_sync_backend.features.role.model.dto.request;

import org.hibernate.validator.constraints.UUID;

public record RoleCreateDTO(
        String name,
        UUID departmentId) {

}
