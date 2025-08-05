package com.example.people_sync_backend.features.country.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/countries")
public class CountryController {

    @GetMapping
    public String getCountries() {
        return "Países";
    }
}
