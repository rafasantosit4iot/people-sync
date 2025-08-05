package com.example.people_sync_backend.features.company.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class CompanySummaryConverter implements EntitySummaryConverter<Company, CompanySummaryDTO> {

    @Override
    public CompanySummaryDTO toSummaryDTO(Company company) {
        return new CompanySummaryDTO(
                company.getId(),
                company.getName(),
                company.getFoundationYear());
    }

    @Override
    public List<CompanySummaryDTO> toSummaryListDTO(Collection<Company> companies) {
        return companies.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
