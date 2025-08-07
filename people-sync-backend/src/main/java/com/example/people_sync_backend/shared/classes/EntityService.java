package com.example.people_sync_backend.shared.classes;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;

public abstract class EntityService<BaseEntity, CreateEntity, ResponseEntity, Repository extends JpaRepository<BaseEntity, UUID>, Mapper extends EntityMapper<BaseEntity, CreateEntity, ResponseEntity>> {

    protected final Repository entityRepository;
    protected final Mapper entityMapper;

    public EntityService(Repository entityRepository, Mapper entityMapper) {
        this.entityRepository = entityRepository;
        this.entityMapper = entityMapper;
    }

    public ResponseEntity getEntityById(UUID entityId) {
        BaseEntity entitySearched = entityRepository.findById(entityId)
                .orElseThrow(() -> new EntityNotFoundException("Não encontrado"));
        return entityMapper.toDTOResponse(entitySearched);
    }

    public List<ResponseEntity> getAllEntityList() {
        List<BaseEntity> entities = entityRepository.findAll();
        return entityMapper.toDTOListResponse(entities);
    }

    public Page<ResponseEntity> getEntityPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BaseEntity> companies = entityRepository.findAll(pageable);
        return entityMapper.toDTOPageResponse(companies);
    }

    public ResponseEntity createEntity(CreateEntity createEntity) {
        BaseEntity entity = entityMapper.toEntity(createEntity);
        entity = validateBeforeSave(entity, createEntity);
        entity = entityRepository.save(entity);
        return entityMapper.toDTOResponse(entity);
    }
    
    public ResponseEntity updateEntity(UUID entityId, CreateEntity createEntity) {

        if (!entityRepository.findById(entityId).isPresent()) {
            throw new EntityNotFoundException("Não encontrado");
        }
        
        BaseEntity entity = entityMapper.toEntity(createEntity);
        entity = validateBeforeSave(entity, createEntity);
        entity = entityRepository.save(entity);
        return entityMapper.toDTOResponse(entity);
    }

    public void deleteEntity(UUID entityId) {
        entityRepository.deleteById(entityId);
    }

    protected BaseEntity validateBeforeSave(BaseEntity entity, CreateEntity createEntity) {
        return entity;
    }
}
