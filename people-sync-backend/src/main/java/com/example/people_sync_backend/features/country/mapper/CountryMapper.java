package com.example.people_sync_backend.features.country.mapper;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.country.model.Country;
import com.example.people_sync_backend.features.country.model.dto.request.CountryCreateDTO;
import com.example.people_sync_backend.features.country.model.dto.response.CountryResponseDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

@Component
public class CountryMapper implements EntityMapper<Country, CountryCreateDTO, CountryResponseDTO> {

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

    @Override
    public Page<CountryResponseDTO> toDTOPageResponse(Page<Country> countries) {
        return countries.map(this::toDTOResponse);
    }

    @Override
    public List<CountryResponseDTO> toDTOListResponse(Collection<Country> countries) {
        return countries.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
