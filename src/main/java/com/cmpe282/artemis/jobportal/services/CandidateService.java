package com.cmpe282.artemis.jobportal.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.MediaRepository;

@Service
public class CandidateService {

	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateService(CandidateRepository candidateRepository, MediaRepository mediaRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	public Candidate save(Candidate candidate) {
		
		candidate.setId(UUID.randomUUID().toString());
		return candidateRepository.save(candidate);
	}

}
