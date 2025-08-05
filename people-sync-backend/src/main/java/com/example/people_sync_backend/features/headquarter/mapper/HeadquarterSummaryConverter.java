package com.example.people_sync_backend.features.headquarter.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.headquarter.model.Headquarter;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntitySummaryConverter;

@Component
public class HeadquarterSummaryConverter implements EntitySummaryConverter<Headquarter, HeadquarterSummaryDTO> {

    @Override
    public HeadquarterSummaryDTO toSummaryDTO(Headquarter headquarter) {
        return new HeadquarterSummaryDTO(
                headquarter.getId(),
                headquarter.getCity(),
                headquarter.getStreet(),
                headquarter.getNumber(),
                headquarter.getCompany().getName(),
                headquarter.getCountry().getName());
    }

    @Override
    public List<HeadquarterSummaryDTO> toSummaryListDTO(Collection<Headquarter> headquarters) {
        return headquarters.stream()
                .map(this::toSummaryDTO)
                .collect(Collectors.toList());
    }
}
