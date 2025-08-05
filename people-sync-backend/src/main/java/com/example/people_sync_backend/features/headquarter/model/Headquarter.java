package com.example.people_sync_backend.features.headquarter.model;

import java.util.UUID;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.country.model.Country;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "headquarters")
public class Headquarter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String city;
    private String street;
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;
}
