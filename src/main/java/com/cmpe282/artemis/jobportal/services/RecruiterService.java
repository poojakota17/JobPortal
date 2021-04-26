package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.entities.Recruiter;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import com.cmpe282.artemis.jobportal.repositories.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecruiterService {

    private RecruiterRepository recruiterRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public RecruiterService(RecruiterRepository recruiterRepository, CompanyRepository companyRepository) {
        this.recruiterRepository = recruiterRepository;
        this.companyRepository = companyRepository;
    }

    public Recruiter addRecruiter(String companyId, Recruiter recruiter) {
        Company company = companyRepository.findById(companyId).get();
        recruiter.setId(UUID.randomUUID().toString());
        recruiter.setCompany(company);
        return recruiterRepository.save(recruiter);
    }
}
