package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.Education;
import com.cmpe282.artemis.jobportal.services.EducationService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/{candidateId}/education")
public class EducationController {

    private EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public Education save(@PathVariable String candidateId, @RequestBody Education education){
        return educationService.save(education, candidateId);
    }
}
