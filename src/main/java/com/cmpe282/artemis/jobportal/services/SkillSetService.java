package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.SkillSet;
import com.cmpe282.artemis.jobportal.repositories.SkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillSetService {

    private SkillSetRepository skillSetRepository;

    @Autowired
    public SkillSetService(SkillSetRepository skillSetRepository) {
        this.skillSetRepository = skillSetRepository;
    }

    public SkillSet addSkillSet(SkillSet skillSet) {
        skillSet.setSkill(skillSet.getSkill().toUpperCase());
        return skillSetRepository.save(skillSet);
    }

    public Iterable<SkillSet> getAllSkillSets() {
        return skillSetRepository.findAll();
    }
}
