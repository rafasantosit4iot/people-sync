package com.example.people_sync_backend.features.country.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.people_sync_backend.features.headquarter.model.Headquarter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, length = 3, name = "code")
    private String isoCode;

    @OneToMany(mappedBy="country")
    private Set<Headquarter> headquarters = new HashSet<>();
}
