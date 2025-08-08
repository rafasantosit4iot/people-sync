package com.example.people_sync_backend.shared.classes;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.shared.classes.errors.GlobalNotFoundException;
import com.example.people_sync_backend.shared.interfaces.CrudService;


public abstract class EntityService<Base, Create, Response, Repository extends JpaRepository<Base, UUID>, Mapper extends EntityMapper<Base, Create, Response>> implements CrudService<Create, Response> {

    protected final Repository entityRepository;
    protected final Mapper entityMapper;

    public EntityService(Repository entityRepository, Mapper entityMapper) {
        this.entityRepository = entityRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Response getEntityById(UUID entityId) {
        Base entitySearched = entityRepository.findById(entityId).orElseThrow(GlobalNotFoundException::new);
        return entityMapper.toDTOResponse(entitySearched);
    }

    @Override
    public List<Response> getAllEntityList() {
        List<Base> entities = entityRepository.findAll();
        return entityMapper.toDTOListResponse(entities);
    }

    @Override
    public Page<Response> getEntityPage(int pageNumber, int pageSize, Sort sort) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Base> entities = entityRepository.findAll(pageable);
        return entityMapper.toDTOPageResponse(entities);
    }

    @Override
    public Response createEntity(Create createEntity) {
        Base entity = entityMapper.toEntity(createEntity);
        entity = validateBeforeSave(entity, createEntity);
        entity = entityRepository.save(entity);
        return entityMapper.toDTOResponse(entity);
    }
    
    @Override
    public Response updateEntity(UUID entityId, Create createEntity) {

        if (!entityRepository.existsById(entityId)) {
            throw new GlobalNotFoundException();
        }
        
        Base entity = entityMapper.toEntity(createEntity);
        entity = validateBeforeSave(entity, createEntity);
        entity = entityRepository.save(entity);
        return entityMapper.toDTOResponse(entity);
    }
    
    @Override
    public void deleteEntity(UUID entityId) {
        if (!entityRepository.existsById(entityId)) {
            throw new GlobalNotFoundException();
        }

        entityRepository.deleteById(entityId);
    }

    protected Base validateBeforeSave(Base entity, Create createEntity) {
        return entity;
    }
}
