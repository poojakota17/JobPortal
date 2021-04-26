package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company) {
        company.setCompanyId(UUID.randomUUID().toString());
        return companyRepository.save(company);
    }

}
