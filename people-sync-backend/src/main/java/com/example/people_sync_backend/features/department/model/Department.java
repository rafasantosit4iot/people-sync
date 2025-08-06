package com.example.people_sync_backend.features.department.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.role.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false, length=150)
    private String title;

    @OneToMany(mappedBy = "department")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy="departments")
    private Set<Company> companies;
}
