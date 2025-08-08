package com.example.people_sync_backend.features.role.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.role.model.Role;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;
import com.example.people_sync_backend.shared.classes.EntitySummaryConverter;

@Component
public class RoleSummaryConverter extends EntitySummaryConverter<Role, RoleSummaryDTO> {

    @Override
    public RoleSummaryDTO toSummaryDTO(Role role) {
        return new RoleSummaryDTO(
                role.getId(),
                role.getName(),
                role.getDepartment().getName());
    }
}
