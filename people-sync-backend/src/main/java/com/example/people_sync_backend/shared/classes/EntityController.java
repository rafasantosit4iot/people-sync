package com.example.people_sync_backend.shared.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.people_sync_backend.shared.classes.errors.InvalidSortParameterException;
import com.example.people_sync_backend.shared.interfaces.CrudService;

import jakarta.validation.Valid;

public abstract class EntityController<Create, Response, Service extends CrudService<Create, Response>> {

    private final Service entityService;

    public EntityController(Service entityService) {
        this.entityService = entityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getEntityById(@PathVariable UUID id) {
        Response entity = entityService.getEntityById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Response>> getAllEntities() {
        List<Response> entities = entityService.getAllEntityList();
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }

    @GetMapping
    public ResponseEntity<Page<Response>> getPageEntities(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "18") int pageSize,
            @RequestParam(defaultValue = "id") String parameters,
            @RequestParam(defaultValue = "asc") String order) {
        Page<Response> entities = entityService.getEntityPage(
                pageNumber,
                pageSize,
                parseSort(parameters, order));
        return ResponseEntity.status(HttpStatus.OK).body(entities);
    }

    private Sort parseSort(String parameters, String order) {
        try {
            Sort.Direction direction = Sort.Direction.fromString(order.toLowerCase());
            String[] fields = parameters.split("\\s*,\\s*");

            if (fields.length == 0) {
                fields = new String[] { "id" }; // Fallback
            }

            List<Sort.Order> orders = new ArrayList<>();
            for (String field : fields) {
                if (!field.isEmpty()) {
                    orders.add(new Sort.Order(direction, field.trim()));
                }
            }

            return Sort.by(orders);
        } catch (IllegalArgumentException e) {
            throw new InvalidSortParameterException(
                    "Parâmetros inválidos. Formato esperado: ?parameters=campo1,campo2&order=asc|desc");
        }
    }

    @PostMapping
    public ResponseEntity<Response> createEntity(@Valid @RequestBody Create newEntity) {
        Response entity = entityService.createEntity(newEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateEntity(
            @PathVariable UUID id,
            @Valid @RequestBody Create newBody) {
        Response entity = entityService.updateEntity(id, newBody);
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable UUID id) {
        entityService.deleteEntity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
