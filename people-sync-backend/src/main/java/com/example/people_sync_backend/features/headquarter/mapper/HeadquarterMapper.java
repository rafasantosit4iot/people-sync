package com.example.people_sync_backend.features.headquarter.mapper;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.mapper.CompanySummaryConverter;
import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.country.mapper.CountrySummaryConverter;
import com.example.people_sync_backend.features.country.model.dto.response.CountrySummaryDTO;
import com.example.people_sync_backend.features.headquarter.model.Headquarter;
import com.example.people_sync_backend.features.headquarter.model.dto.request.HeadquarterCreateDTO;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterResponseDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HeadquarterMapper implements EntityMapper<Headquarter, HeadquarterCreateDTO, HeadquarterResponseDTO> {

    private final CompanySummaryConverter companySummaryConverter;
    private final CountrySummaryConverter countrySummaryConverter;

    @Override
    public Headquarter toEntity(HeadquarterCreateDTO headquarterCreateDTO) {
        Headquarter headquarter = new Headquarter();

        headquarter.setCity(headquarterCreateDTO.city());
        headquarter.setStreet(headquarterCreateDTO.street());
        headquarter.setNumber(headquarterCreateDTO.number());

        headquarter.setCompany(company);
        headquarter.setCompany(country);

        return headquarter;
    }

    @Override
    public HeadquarterResponseDTO toDTOResponse(Headquarter headquarter) {
        UUID id = headquarter.getId();
        String city = headquarter.getCity();
        String street = headquarter.getStreet();
        Integer number = headquarter.getNumber();

        CompanySummaryDTO company = companySummaryConverter.toSummaryDTO(headquarter.getCompany());
        CountrySummaryDTO country = countrySummaryConverter.toSummaryDTO(headquarter.getCountry());

        return new HeadquarterResponseDTO(id, city, street, number, company, country);
    }

    @Override
    public Page<HeadquarterResponseDTO> toDTOPageResponse(Page<Headquarter> headquarters) {
        return headquarters.map(this::toDTOResponse);
    }

    @Override
    public List<HeadquarterResponseDTO> toDTOListResponse(Collection<Headquarter> headquarters) {
        return headquarters.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
