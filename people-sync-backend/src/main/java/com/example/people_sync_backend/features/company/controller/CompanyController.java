package com.example.people_sync_backend.features.company.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.people_sync_backend.features.company.model.dto.request.CompanyCreateDTO;
import com.example.people_sync_backend.features.company.model.dto.response.CompanyResponseDTO;
import com.example.people_sync_backend.features.company.service.CompanyService;
import com.example.people_sync_backend.shared.classes.EntityController;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins="http://localhost:4202")
public class CompanyController extends EntityController<CompanyCreateDTO, CompanyResponseDTO, CompanyService> {

    public CompanyController(CompanyService service) {
        super(service);
    }
}
