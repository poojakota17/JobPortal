package com.cmpe282.artemis.jobportal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cmpe282.artemis.jobportal.entities.Education;
import com.cmpe282.artemis.jobportal.entities.WorkHistory;
import com.cmpe282.artemis.jobportal.repositories.EducationRepository;
import com.cmpe282.artemis.jobportal.repositories.WorkHistoryRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.MediaRepository;

@Service
public class CandidateService {

	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	public Candidate save(Candidate candidate) {
		
		candidate.setId(UUID.randomUUID().toString());
		return candidateRepository.save(candidate);
	}

	public Candidate findACandidate(String candidateId){
		return candidateRepository.findById(candidateId).get();
	}

}
