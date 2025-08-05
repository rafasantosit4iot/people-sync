package com.example.people_sync_backend.shared.interfaces;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;


public interface EntityMapper<E, CreateD, ResponseD> {

    public E toEntity(CreateD entityDTO);

    public ResponseD toDTOResponse(E entity);

    public Page<ResponseD> toDTOPageResponse(Page<E> entityPage);

    public List<ResponseD> toDTOListResponse(Collection<E> entityCollection);
}
