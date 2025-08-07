package com.example.people_sync_backend.features.role.model.dto.request;

import java.util.UUID;

public record RoleCreateDTO(
        String name,
        UUID departmentId) {

}
