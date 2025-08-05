package com.example.people_sync_backend.features.role.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class RoleController {
    
    @GetMapping
    public String getRoles() {
        return "Cargos";
    }
}
