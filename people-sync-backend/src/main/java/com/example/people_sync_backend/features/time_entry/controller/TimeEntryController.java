package com.example.people_sync_backend.features.time_entry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/time_entries")
public class TimeEntryController {
    
    @GetMapping
    public String getEntries() {
        return "Entradas de trabalho";
    }
}
