package com.example.people_sync_backend.features.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/projects")
public class ProjectController {
    
    @GetMapping
    public String getProjects() {
        return "Projetos";
    }
}
