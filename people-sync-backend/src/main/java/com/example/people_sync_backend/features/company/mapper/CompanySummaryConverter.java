package com.example.people_sync_backend.features.company.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.shared.classes.EntitySummaryConverter;

@Component
public class CompanySummaryConverter extends EntitySummaryConverter<Company, CompanySummaryDTO> {

    @Override
    public CompanySummaryDTO toSummaryDTO(Company company) {
        return new CompanySummaryDTO(
                company.getId(),
                company.getName(),
                company.getFoundationYear());
    }
}
