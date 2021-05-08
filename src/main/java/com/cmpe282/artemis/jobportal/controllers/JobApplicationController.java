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

    @GetMapping("/jobpost/{jobPostId}")
    public Iterable<JobApplication> getJobApplicationsByJobPostId(@PathVariable String jobPostId){
        return jobApplicationService.getJobApplicationsByJobPostId(jobPostId);
    }


    @PostMapping("/{jobApplicationId}")
    public JobApplication reject(@PathVariable String jobApplicationId) throws IOException {
        return jobApplicationService.reject(jobApplicationId);
    }

    @PutMapping("/zoomnotification")
    public void sendZoomNotification(@RequestBody JobApplication jobApplication,@RequestParam String duration,@RequestParam String time,@RequestParam String url) throws IOException{
         jobApplicationService.sendZoomNotificationEmail(jobApplication,duration,time,url);
    }



}
