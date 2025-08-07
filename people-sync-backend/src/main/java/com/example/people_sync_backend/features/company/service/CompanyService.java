package com.example.people_sync_backend.features.company.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.company.mapper.CompanyMapper;
import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.model.dto.request.CompanyCreateDTO;
import com.example.people_sync_backend.features.company.model.dto.response.CompanyResponseDTO;
import com.example.people_sync_backend.features.company.repository.CompanyRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

@Service
public class CompanyService extends EntityService<Company, CompanyCreateDTO, CompanyResponseDTO, CompanyRepository, CompanyMapper> {

    public CompanyService(CompanyRepository entityRepository, CompanyMapper entityMapper) {
        super(entityRepository, entityMapper);
    }
}
