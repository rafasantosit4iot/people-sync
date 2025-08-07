package com.example.people_sync_backend.features.headquarter.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.repository.CompanyRepository;
import com.example.people_sync_backend.features.country.model.Country;
import com.example.people_sync_backend.features.country.repository.CountryRepository;
import com.example.people_sync_backend.features.headquarter.mapper.HeadquarterMapper;
import com.example.people_sync_backend.features.headquarter.model.Headquarter;
import com.example.people_sync_backend.features.headquarter.model.dto.request.HeadquarterCreateDTO;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterResponseDTO;
import com.example.people_sync_backend.features.headquarter.repository.HeadquarterRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HeadquarterService extends EntityService<Headquarter, HeadquarterCreateDTO, HeadquarterResponseDTO, HeadquarterRepository, HeadquarterMapper> {

    private final CompanyRepository companyRepository;
    private final CountryRepository countryRepository;

    public HeadquarterService(CompanyRepository companyRepository, CountryRepository countryRepository, HeadquarterRepository entityRepository, HeadquarterMapper entityMapper) {
        super(entityRepository, entityMapper);
        this.companyRepository = companyRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public HeadquarterResponseDTO createEntity(HeadquarterCreateDTO headquarterCreateDTO) {
        Headquarter headquarter = entityMapper.toEntity(headquarterCreateDTO);
        headquarter = entityRepository.save(headquarter);
        headquarter = validateBeforeSave(headquarter, headquarterCreateDTO);
        return entityMapper.toDTOResponse(headquarter);
    }

    @Override
    protected Headquarter validateBeforeSave(Headquarter headquarter, HeadquarterCreateDTO headquarterCreateDTO) {

        Company company = companyRepository.findById(headquarterCreateDTO.companyId())
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));

        Country country = countryRepository.findById(headquarterCreateDTO.countryId())
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado"));

        headquarter.setCompany(company);
        headquarter.setCountry(country);

        return headquarter;
    }
}
