package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.services.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/job_application")
public class JobApplicationController {

    private JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public JobApplication save(@RequestBody JobApplication jobApplication) throws IOException {
        return jobApplicationService.save(jobApplication);
    }

    @GetMapping("/{candidateId}")
    public Iterable<JobApplication> getJobApplicationsByCandidateId(@PathVariable String candidateId){
        return jobApplicationService.getJobApplicationsByCandidateId(candidateId);
    }
}
