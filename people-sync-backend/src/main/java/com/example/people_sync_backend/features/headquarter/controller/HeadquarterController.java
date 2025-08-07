package com.example.people_sync_backend.features.headquarter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/headquarters")
public class HeadquarterController {
    
    @GetMapping
    public String getHeadquarters() {
        return "Sedes";
    }
}
