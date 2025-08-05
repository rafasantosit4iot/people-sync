package com.example.people_sync_backend.features.company.mapper;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.people_sync_backend.features.company.model.Company;
import com.example.people_sync_backend.features.company.model.dto.request.CompanyCreateDTO;
import com.example.people_sync_backend.features.company.model.dto.response.CompanyResponseDTO;
import com.example.people_sync_backend.features.employee.mapper.EmployeeSummaryConverter;
import com.example.people_sync_backend.features.employee.model.dto.response.EmployeeSummaryDTO;
import com.example.people_sync_backend.features.headquarter.mapper.HeadquarterSummaryConverter;
import com.example.people_sync_backend.features.headquarter.model.dto.response.HeadquarterSummaryDTO;
import com.example.people_sync_backend.shared.interfaces.EntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CompanyMapper implements EntityMapper<Company, CompanyCreateDTO, CompanyResponseDTO> {

    private final HeadquarterSummaryConverter headquarterSummaryConverter;
    private final EmployeeSummaryConverter employeeSummaryConverter;

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

        List<HeadquarterSummaryDTO> headquarters = headquarterSummaryConverter.toSummaryListDTO(company.getHeadquarters());

        List<EmployeeSummaryDTO> employees = employeeSummaryConverter.toSummaryListDTO(company.getEmployees());

        return new CompanyResponseDTO(id, name, foundationYear, headquarters, employees);
    }

    @Override
    public Page<CompanyResponseDTO> toDTOPageResponse(Page<Company> companies) {
        return companies.map(this::toDTOResponse);
    }

    @Override
    public List<CompanyResponseDTO> toDTOListResponse(Collection<Company> companies) {
        return companies.stream()
                .map(this::toDTOResponse)
                .collect(Collectors.toList());
    }
}
