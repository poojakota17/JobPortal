package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.entities.Recruiter;
import com.cmpe282.artemis.jobportal.entities.SkillSet;
import com.cmpe282.artemis.jobportal.enums.EventType;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import com.cmpe282.artemis.jobportal.repositories.JobPostRepository;
import com.cmpe282.artemis.jobportal.repositories.RecruiterRepository;
import com.cmpe282.artemis.jobportal.repositories.SkillSetRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JobPostService {

    private JobPostRepository jobPostRepository;
    private CompanyRepository companyRepository;
    private RecruiterRepository recruiterRepository;
    private PublisherClient publisherClient;
    private SkillSetRepository skillSetRepository;

    @Autowired
    public JobPostService(JobPostRepository jobPostRepository, CompanyRepository companyRepository, RecruiterRepository recruiterRepository, PublisherClient publisherClient, SkillSetRepository skillSetRepository) {
        this.jobPostRepository = jobPostRepository;
        this.companyRepository = companyRepository;
        this.recruiterRepository = recruiterRepository;
        this.publisherClient = publisherClient;
        this.skillSetRepository = skillSetRepository;
    }

    public JobPost createJobPost(String companyId, String recruiterId, JobPost jobPost) throws JsonProcessingException {
        Company company = companyRepository.findById(companyId).get();
        Recruiter recruiter = recruiterRepository.findById(recruiterId).get();
        long randomNum = ThreadLocalRandom.current().nextLong(100000, 1000000);
        jobPost.setId(jobPost.getJobType().toString().substring(0,2).concat(String.valueOf(randomNum)));
        List<SkillSet> skillSetList = jobPost.getSkillSetList();
        List<SkillSet> newSkillSetList = new ArrayList<>();
        for (SkillSet skill: skillSetList){
            SkillSet newSkill = skillSetRepository.findById(skill.getId()).get();
            newSkillSetList.add(newSkill);
        }
        jobPost.setSkillSetList(newSkillSetList);
        jobPost.setCompany(company);
        jobPost.setRecruiter(recruiter);
        JobPost newJobPost = jobPostRepository.save(jobPost);
        publisherClient.publishJobPostingEvent(newJobPost, EventType.ENTITY_CREATE);
        return newJobPost;
    }

    public Iterable<JobPost> getJobPostByCompanyId(String companyId) {
        return jobPostRepository.findByCompanyCompanyId(companyId);
    }
}
