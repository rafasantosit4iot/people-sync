package com.example.people_sync_backend.features.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    
    @GetMapping
    public String getDepartments() {
        return "Departamentos";
    }
}
