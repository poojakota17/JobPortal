package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class CandidateService {

	private CandidateRepository candidateRepository;
	
	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	public Candidate save(Candidate candidate) {
		try {
			Candidate existingCandidate = candidateRepository.findById(candidate.getId()).get();
			boolean isSaveNeeded = false;

			if(existingCandidate.getFirstName() == null && candidate.getFirstName() != null){
				existingCandidate.setFirstName(candidate.getFirstName());
				isSaveNeeded = true;
			}
			if(existingCandidate.getEmail() == null && candidate.getEmail() != null){
				existingCandidate.setEmail(candidate.getEmail());
				isSaveNeeded = true;
			}
			if(existingCandidate.getLastName() == null && candidate.getLastName() != null){
				existingCandidate.setLastName(candidate.getLastName());
				isSaveNeeded = true;
			}
			if(existingCandidate.getPhone() == null && candidate.getPhone() != null){
				existingCandidate.setPhone(candidate.getPhone());
				isSaveNeeded = true;
			}
			if(isSaveNeeded) {
				existingCandidate = candidateRepository.save(existingCandidate);
			}
			return existingCandidate;
		} catch(Exception e) {
			if(candidate.getId() == null || StringUtils.isEmpty(candidate.getId()))
				candidate.setId(UUID.randomUUID().toString());
			Candidate newCandidate = candidateRepository.save(candidate);
			return newCandidate;
		}
	}

	public Candidate findACandidate(String candidateId){
		return candidateRepository.findById(candidateId).get();
	}

}
