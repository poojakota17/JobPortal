package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.entities.Recruiter;
import com.cmpe282.artemis.jobportal.services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/recruiter")
public class RecruiterController {

    private RecruiterService recruiterService;

    @Autowired
    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @PostMapping("/new/{companyId}")
    public Recruiter addRecruiter(@PathVariable String companyId, @RequestBody Recruiter recruiter){
        return recruiterService.addRecruiter(companyId,recruiter);
    }
}
