package com.cmpe282.artemis.jobportal.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe282.artemis.jobportal.entities.DTO.JobPostAndCandidateDto;
import com.cmpe282.artemis.jobportal.services.JobPostAndCandidateService;

@RestController
@CrossOrigin
@RequestMapping("/api/jobpost_candidate")
public class JobPostAndCandidateController {

	private JobPostAndCandidateService jobPostAndCandidateService;
	
	public JobPostAndCandidateController(JobPostAndCandidateService jobPostAndCandidateService) {
        this.jobPostAndCandidateService = jobPostAndCandidateService;
    }


	@GetMapping("{jobApplicationId}")
	public JobPostAndCandidateDto findScores(@PathVariable String jobApplicationId) {
		return jobPostAndCandidateService.findScoreForAJobPost(jobApplicationId);
	}
}
