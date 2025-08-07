package com.example.people_sync_backend.features.headquarter.mapper;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.headquarter.model.Headquarter;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterSummaryDTO;
import com.example.people_sync_backend.shared.classes.EntitySummaryConverter;

@Component
public class HeadquarterSummaryConverter extends EntitySummaryConverter<Headquarter, HeadquarterSummaryDTO> {

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
}
