package com.example.people_sync_backend.features.company.mapper;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.model.dto.request.CompanyCreateDTO;
import com.example.people_sync_backend.features.company.model.dto.response.CompanyResponseDTO;
import com.example.people_sync_backend.features.department.mapper.DepartmentSummaryConverter;
import com.example.people_sync_backend.features.department.model.dto.response.DepartmentSummaryDTO;
import com.example.people_sync_backend.features.employee.mapper.EmployeeSummaryConverter;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.headquarter.mapper.HeadquarterSummaryConverter;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterSummaryDTO;
import com.example.people_sync_backend.shared.classes.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CompanyMapper extends EntityMapper<Company, CompanyCreateDTO, CompanyResponseDTO> {

    private final HeadquarterSummaryConverter headquarterSummaryConverter;
    private final EmployeeSummaryConverter employeeSummaryConverter;
    private final DepartmentSummaryConverter departmentSummaryConverter;

    @Override
    public Company toEntity(CompanyCreateDTO createCompanyDTO) {
        Company company = new Company();

        company.setName(createCompanyDTO.name());
        company.setFoundationYear(createCompanyDTO.foundationYear());

        return company;
    }

    @Override
    public CompanyResponseDTO toDTOResponse(Company company) {
        UUID id = company.getId();
        String name = company.getName();
        Integer foundationYear = company.getFoundationYear();

        List<HeadquarterSummaryDTO> headquarters = headquarterSummaryConverter
                .toSummaryListDTO(company.getHeadquarters());
        List<EmployeeSummaryDTO> employees = employeeSummaryConverter.toSummaryListDTO(company.getEmployees());
        List<DepartmentSummaryDTO> departments = departmentSummaryConverter.toSummaryListDTO(company.getDepartments());

        return new CompanyResponseDTO(id, name, foundationYear, headquarters, employees, departments);
    }
}
