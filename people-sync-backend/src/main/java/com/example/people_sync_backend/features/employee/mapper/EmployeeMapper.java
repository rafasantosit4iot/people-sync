package com.example.people_sync_backend.features.employee.mapper;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.mapper.CompanySummaryConverter;
import com.example.people_sync_backend.features.company.model.dto.response.CompanySummaryDTO;
import com.example.people_sync_backend.features.employee.model.Employee;
import com.example.people_sync_backend.features.employee.model.dto.request.EmployeeCreateDTO;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeResponseDTO;
import com.example.people_sync_backend.features.employee.model.enums.ContractType;
import com.example.people_sync_backend.features.employee.model.enums.EmployeeGender;
import com.example.people_sync_backend.features.role.mapper.RoleSummaryConverter;
import com.example.people_sync_backend.features.role.model.dto.response.RoleSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeMapper implements EntityMapper<Employee, EmployeeCreateDTO, EmployeeResponseDTO> {

    private final CompanySummaryConverter companySummaryConverter;
    private final RoleSummaryConverter roleSummaryConverter;

    @Override
    public Employee toEntity(EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = new Employee();

        employee.setName(employeeCreateDTO.name());
        employee.setEmail(employeeCreateDTO.email());
        employee.setContract(employeeCreateDTO.contract());
        employee.setRegister(employeeCreateDTO.register());
        employee.setPassword(employeeCreateDTO.password());
        employee.setPcd(employeeCreateDTO.pcd());
        employee.setBirthday(employeeCreateDTO.birthday());
        employee.setGender(employeeCreateDTO.gender());
        employee.setActive(employeeCreateDTO.active());

        employee.setCompany(company);
        employee.setRole(role);

        return employee;
    }

    @Override
    public EmployeeResponseDTO toDTOResponse(Employee employee) {
        UUID id = employee.getId();
        String name = employee.getName();
        String email = employee.getEmail();
        ContractType contract = employee.getContract();
        String register = employee.getRegister();
        boolean pcd = employee.isPcd();
        LocalDate birthday = employee.getBirthday();
        EmployeeGender gender = employee.getGender();
        boolean active = employee.isActive();

        CompanySummaryDTO company = companySummaryConverter.toSummaryDTO(employee.getCompany());

        RoleSummaryDTO role = roleSummaryConverter.toSummaryDTO(employee.getRole());

        return new EmployeeResponseDTO(id, name, email, contract, register, pcd, birthday, gender, active,
                company, role);
    }

    @Override
    public Page<EmployeeResponseDTO> toDTOPageResponse(Page<Employee> employees) {
        return employees.map(this::toDTOResponse);
    }

    @Override
    public List<EmployeeResponseDTO> toDTOListResponse(Collection<Employee> employees) {
        return employees.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
