package com.example.people_sync_backend.features.country.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.country.mapper.CountryMapper;
import com.example.people_sync_backend.features.country.model.Country;
import com.example.people_sync_backend.features.country.model.dto.request.CountryCreateDTO;
import com.example.people_sync_backend.features.country.model.dto.response.CountryResponseDTO;
import com.example.people_sync_backend.features.country.repository.CountryRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

@Service
public class CountryService extends EntityService<Country, CountryCreateDTO, CountryResponseDTO, CountryRepository, CountryMapper> {

    public CountryService(CountryRepository entityRepository, CountryMapper entityMapper) {
        super(entityRepository, entityMapper);
    }
}
