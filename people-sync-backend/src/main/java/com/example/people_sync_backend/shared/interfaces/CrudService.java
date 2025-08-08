package com.example.people_sync_backend.shared.interfaces;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface CrudService<Create, Response> {
    Response getEntityById(UUID id);

    List<Response> getAllEntityList();

    Page<Response> getEntityPage(int pageNumber, int pageSize, Sort sort);

    Response createEntity(Create dto);

    Response updateEntity(UUID id, Create dto);

    void deleteEntity(UUID id);
}
