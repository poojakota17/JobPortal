package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.services.JobPostService;
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
    public JobPost createNewJobPost(@PathVariable String companyId, @PathVariable String recruiterId, @RequestBody JobPost jobPost){
        return jobPostService.createJobPost(companyId,recruiterId,jobPost);
    }
}
