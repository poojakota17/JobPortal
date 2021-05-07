package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.services.JobPostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/jobpost")
public class JobPostController {

    private JobPostService jobPostService;

    @Autowired
    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @PostMapping("/new/{companyId}/{recruiterId}")
    public JobPost createNewJobPost(@PathVariable String companyId, @PathVariable String recruiterId, @RequestBody JobPost jobPost) throws JsonProcessingException {
        return jobPostService.createJobPost(companyId,recruiterId,jobPost);
    }

    @GetMapping("/{companyId}")
    public Iterable<JobPost> getJobPostByCompanyId(@PathVariable String companyId){
        return jobPostService.getJobPostByCompanyId(companyId);
    }
}
