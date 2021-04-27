package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.services.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Company save(@RequestBody Company company) throws JsonProcessingException {
        return companyService.save(company);
    }
    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable String companyId){
        return companyService.getCompanyById(companyId);
    }

}