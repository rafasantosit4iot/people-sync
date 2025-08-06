package com.example.people_sync_backend.features.role.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.role.model.Role;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class RoleSummaryConverter implements EntitySummaryConverter<Role, RoleSummaryDTO> {

    @Override
    public RoleSummaryDTO toSummaryDTO(Role role) {
        return new RoleSummaryDTO(
                role.getId(),
                role.getName(),
                role.getDepartment().getTitle());
    }

    @Override
    public List<RoleSummaryDTO> toSummaryListDTO(Collection<Role> roles) {
        return roles.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
