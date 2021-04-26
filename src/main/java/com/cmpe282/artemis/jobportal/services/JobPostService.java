package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.entities.Recruiter;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import com.cmpe282.artemis.jobportal.repositories.JobPostRepository;
import com.cmpe282.artemis.jobportal.repositories.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class JobPostService {

    private JobPostRepository jobPostRepository;
    private CompanyRepository companyRepository;
    private RecruiterRepository recruiterRepository;

    @Autowired
    public JobPostService(JobPostRepository jobPostRepository, CompanyRepository companyRepository, RecruiterRepository recruiterRepository) {
        this.jobPostRepository = jobPostRepository;
        this.companyRepository = companyRepository;
        this.recruiterRepository = recruiterRepository;
    }

    public JobPost createJobPost(String companyId, String recruiterId, JobPost jobPost) {
        Company company = companyRepository.findById(companyId).get();
        Recruiter recruiter = recruiterRepository.findById(recruiterId).get();
        long randomNum = ThreadLocalRandom.current().nextLong(100000, 1000000);
        jobPost.setId(jobPost.getJobType().toString().substring(0,2).concat(String.valueOf(randomNum)));
        jobPost.setCompany(company);
        jobPost.setRecruiter(recruiter);
        return jobPostRepository.save(jobPost);
    }
}
