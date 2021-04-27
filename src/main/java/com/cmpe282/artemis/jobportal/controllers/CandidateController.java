package com.cmpe282.artemis.jobportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.services.CandidateService;

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
}
