package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Company save(@RequestBody Company company){
        return companyService.save(company);
    }
}