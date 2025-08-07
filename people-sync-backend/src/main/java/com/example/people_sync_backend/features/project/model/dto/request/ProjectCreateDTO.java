package com.example.people_sync_backend.features.project.model.dto.request;

public record ProjectCreateDTO(
                String name,
                String tag,
                String description,
                boolean finalized) {

}
