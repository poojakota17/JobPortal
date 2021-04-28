package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.SkillSet;
import com.cmpe282.artemis.jobportal.services.SkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/skillset")
public class SkillSetController {

    private SkillSetService skillSetService;

    @Autowired
    public SkillSetController(SkillSetService skillSetService) {
        this.skillSetService = skillSetService;
    }

    @PostMapping("/new")
    public SkillSet addSkillSet( @RequestBody SkillSet skillSet){
        return skillSetService.addSkillSet(skillSet);
    }
    @GetMapping("/all")
    public Iterable<SkillSet> getAllSkillSets(){
        return skillSetService.getAllSkillSets();
    }

    @PostMapping("{candidateId}")
    public SkillSet addToCandidateProfile(@PathVariable String candidateId, @RequestBody SkillSet skillSet){
        return skillSetService.addToCandidateProfile(candidateId, skillSet);
    }
}
