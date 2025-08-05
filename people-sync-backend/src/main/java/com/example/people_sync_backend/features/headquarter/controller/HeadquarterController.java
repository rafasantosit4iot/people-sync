package com.example.people_sync_backend.features.headquarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/headquarters")
public class HeadquarterController {
    
    @GetMapping
    public String getHeadquarters() {
        return "Sedes";
    }
}
