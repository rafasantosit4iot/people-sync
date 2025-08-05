package com.example.people_sync_backend.features.country.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.people_sync_backend.features.country.model.Country;

public interface CountryRepository extends JpaRepository<Country, UUID> {

}
