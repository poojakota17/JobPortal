package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.services.SendEmailService;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.services.CandidateService;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/candidate")
public class CandidateController {
	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService=candidateService;
	}

	@PostMapping
	public Candidate save(@RequestBody Candidate candidate) {
		return candidateService.save(candidate);
	}

	@GetMapping("{candidateId}")
	public Candidate findCandidate(@PathVariable String candidateId){
		return candidateService.findACandidate(candidateId);
	}
}
