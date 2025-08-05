package com.example.people_sync_backend.features.project.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.example.people_sync_backend.features.employee.model.Employee;
import com.example.people_sync_backend.features.time_entry.model.TimeEntry;

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
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, length = 10, nullable = false)
    private String tag;

    private String description;
    private boolean finalized;

    @OneToMany(mappedBy = "project")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<TimeEntry> timeEntries = new HashSet<>();
}
