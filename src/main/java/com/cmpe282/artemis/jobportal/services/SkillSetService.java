package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.SkillSet;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.SkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class SkillSetService {

    private SkillSetRepository skillSetRepository;
    private CandidateRepository candidateRepository;

    @Autowired
    public SkillSetService(SkillSetRepository skillSetRepository, CandidateRepository candidateRepository) {
        this.skillSetRepository = skillSetRepository;
        this.candidateRepository = candidateRepository;
    }

    public SkillSet addSkillSet(SkillSet skillSet) {
        skillSet.setSkill(skillSet.getSkill().toUpperCase());
        return skillSetRepository.save(skillSet);
    }

    public Iterable<SkillSet> getAllSkillSets() {
        return skillSetRepository.findAll();
    }

    public SkillSet addToCandidateProfile(String candidateId, SkillSet skill){
        skill.setId(UUID.randomUUID().toString());
        SkillSet skillSet = skillSetRepository.save(skill);
        Candidate candidate = candidateRepository.findById(candidateId).get();
        List<SkillSet> skills = candidate.getSkillSetList();
        skills.add(skillSet);
        candidate.setSkillSetList(skills);
        candidateRepository.save(candidate);
        return skillSet;
    }
}
