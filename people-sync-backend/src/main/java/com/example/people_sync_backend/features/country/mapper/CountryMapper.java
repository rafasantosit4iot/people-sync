package com.example.people_sync_backend.features.country.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.country.model.Country;
import com.example.people_sync_backend.features.country.model.dto.request.CountryCreateDTO;
import com.example.people_sync_backend.features.country.model.dto.response.CountryResponseDTO;
import com.example.people_sync_backend.shared.classes.EntityMapper;

@Component
public class CountryMapper extends EntityMapper<Country, CountryCreateDTO, CountryResponseDTO> {

    @Override
    public Country toEntity(CountryCreateDTO countryCreateDTO) {
        Country country = new Country();

        country.setName(countryCreateDTO.name());
        country.setIsoCode(countryCreateDTO.isoCode());

        return country;
    }

    @Override
    public CountryResponseDTO toDTOResponse(Country country) {
        UUID id = country.getId();
        String name = country.getName();
        String isoCode = country.getIsoCode();

        return new CountryResponseDTO(id, name, isoCode);
    }
}
