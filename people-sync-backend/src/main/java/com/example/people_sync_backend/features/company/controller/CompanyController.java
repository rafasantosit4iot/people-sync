package com.example.people_sync_backend.features.company.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/companies")
@CrossOrigin(origins="http://localhost:4202")
public class CompanyController {
    
    @GetMapping
    public String getCompanies() {
        return "Empresas";
    }
}
