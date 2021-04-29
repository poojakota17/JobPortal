package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import com.cmpe282.artemis.jobportal.repositories.MediaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class CompanyService {

    private UploadAmazonClient amazonClient;
    private CompanyRepository companyRepository;
    private MediaRepository mediaRepository;


    @Autowired
    public CompanyService(UploadAmazonClient amazonClient, CompanyRepository companyRepository, MediaRepository mediaRepository) {
        this.amazonClient = amazonClient;
        this.companyRepository = companyRepository;
        this.mediaRepository = mediaRepository;
    }

    public Company save(Company company) throws JsonProcessingException {
        try {
            Company existingCompany = companyRepository.findById(company.getCompanyId()).get();
            boolean isSaveNeeded = false;

            if(existingCompany.getName() == null && company.getName() != null){
                existingCompany.setName(company.getName());
                isSaveNeeded = true;
            }
            if(existingCompany.getEmail() == null && company.getEmail() != null){
                existingCompany.setEmail(company.getEmail());
                isSaveNeeded = true;
            }
            if(existingCompany.getIndustry() == null && company.getIndustry() != null){
                existingCompany.setIndustry(company.getIndustry());
                isSaveNeeded = true;
            }
            if(existingCompany.getAbout() == null && company.getAbout() != null){
                existingCompany.setAbout(company.getAbout());
                isSaveNeeded = true;
            }
            if(existingCompany.getWebsiteUrl() == null && company.getWebsiteUrl() != null) {
                existingCompany.setWebsiteUrl(company.getWebsiteUrl());
                isSaveNeeded = true;
            }
            if(isSaveNeeded) {
                existingCompany = companyRepository.save(existingCompany);
            }
            return existingCompany;
        } catch(Exception e) {
            if(company.getCompanyId() == null || StringUtils.isEmpty(company.getCompanyId()))
                company.setCompanyId(UUID.randomUUID().toString());
            Company newCompany = companyRepository.save(company);
            return newCompany;
        }
    }

    public Company getCompanyById(String companyId) {
        return companyRepository.findById(companyId).get();
    }
}
