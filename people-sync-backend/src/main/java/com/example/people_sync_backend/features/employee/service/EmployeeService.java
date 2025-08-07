package com.example.people_sync_backend.features.employee.service;

import org.springframework.stereotype.Service;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.repository.CompanyRepository;
import com.example.people_sync_backend.features.employee.mapper.EmployeeMapper;
import com.example.people_sync_backend.features.employee.model.Employee;
import com.example.people_sync_backend.features.employee.model.dto.request.EmployeeCreateDTO;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeResponseDTO;
import com.example.people_sync_backend.features.employee.repository.EmployeeRepository;
import com.example.people_sync_backend.features.role.model.Role;
import com.example.people_sync_backend.features.role.repository.RoleRepository;
import com.example.people_sync_backend.shared.classes.EntityService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService extends EntityService<Employee, EmployeeCreateDTO, EmployeeResponseDTO, EmployeeRepository, EmployeeMapper> {

    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;

    public EmployeeService(CompanyRepository companyRepository, RoleRepository roleRepository, EmployeeRepository entityRepository, EmployeeMapper entityMapper) {
        super(entityRepository, entityMapper);
        this.companyRepository = companyRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public EmployeeResponseDTO createEntity(EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = entityMapper.toEntity(employeeCreateDTO);

        employee.setActive(true);
        employee = validateBeforeSave(employee, employeeCreateDTO);

        employee = entityRepository.save(employee);
        return entityMapper.toDTOResponse(employee);
    }

    @Override
    protected Employee validateBeforeSave(Employee employee, EmployeeCreateDTO employeeCreateDTO) {

        Company company = companyRepository.findById(employeeCreateDTO.companyId())
            .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
            
        Role role = roleRepository.findById(employeeCreateDTO.roleId())
            .orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado"));

        employee.setCompany(company);
        employee.setRole(role);

        return employee;
    }
}
