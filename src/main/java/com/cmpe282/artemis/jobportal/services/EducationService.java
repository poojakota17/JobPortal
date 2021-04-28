package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.Education;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EducationService {

    private EducationRepository educationRepository;
    private CandidateRepository candidateRepository;

    public EducationService(EducationRepository educationRepository, CandidateRepository candidateRepository) {
        this.educationRepository = educationRepository;
        this.candidateRepository = candidateRepository;
    }

    public Education save(Education education, String candidateId){
        education.setId(UUID.randomUUID().toString());
        Education education1 = educationRepository.save(education);
        Candidate candidate = candidateRepository.findById(candidateId).get();
        List<Education> educations = candidate.getEducationList();
        educations.add(education1);
        candidate.setEducationList(educations);
        candidateRepository.save(candidate);
        return education1;
    }
}

