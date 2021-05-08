package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.entities.DTO.JobPostAndCandidateDto;
import com.cmpe282.artemis.jobportal.enums.EventType;
import com.cmpe282.artemis.jobportal.enums.Status;
import com.cmpe282.artemis.jobportal.mapper.JobPostAndCandidateMapper;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.JobApplicationRepository;
import com.cmpe282.artemis.jobportal.repositories.JobPostRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;
    private CandidateRepository candidateRepository;
    private JobPostRepository jobPostRepository;
    private SendEmailService sendEmailService;
    private JobPostAndCandidateDto jobPostAndCandidateDto;
	private JobPostAndCandidateMapper jobPostAndCandidateMapper;
	private PublisherClient publisherClient;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, CandidateRepository candidateRepository, JobPostRepository jobPostRepository, SendEmailService sendEmailService, JobPostAndCandidateMapper jobPostAndCandidateMapper, PublisherClient publisherClient) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.candidateRepository = candidateRepository;
        this.jobPostRepository = jobPostRepository;
        this.sendEmailService = sendEmailService;
        this.jobPostAndCandidateMapper = jobPostAndCandidateMapper;
		this.publisherClient = publisherClient;
    }

    public JobApplication save(JobApplication jobApplication) throws IOException {
        jobApplication.setId(UUID.randomUUID().toString());
        Candidate candidate = candidateRepository.findById(jobApplication.getCandidate().getId()).get();
        jobApplication.setCandidate(candidate);
        JobPost jobPost = jobPostRepository.findById(jobApplication.getJobPost().getId()).get();
        jobApplication.setJobPost(jobPost);
        jobApplication.setAppliedDate(LocalDate.now());
        jobApplication.setStatus(Status.APPLIED);
        JobApplication appliedJob = jobApplicationRepository.save(jobApplication);
        sendEmailService.sendEmail(jobApplication);
        jobPostAndCandidateDto = jobPostAndCandidateMapper.mapDto(jobPost, candidate);
		publisherClient.publishJobPostAndCandidate(jobPostAndCandidateDto, EventType.ENTITY_CREATE);
        return appliedJob;
    }

    public Iterable<JobApplication> getJobApplicationsByCandidateId(String candidateId) {
        return jobApplicationRepository.findByCandidateId(candidateId);
    }
    public Iterable<JobApplication> getJobApplicationsByJobPostId(String jobPostId) {
        return jobApplicationRepository.findByJobPostIdAndStatusEquals(jobPostId, Status.APPLIED);
    }
    public void sendZoomNotificationEmail(JobApplication jobApplication, String duration, String time, String url) throws IOException{
        jobApplication.setStatus(Status.ACCEPT);
        JobPost jobPost = jobPostRepository.findById(jobApplication.getJobPost().getId()).get();
        Candidate candidate= candidateRepository.findById(jobApplication.getCandidate().getId()).get();
        String email= candidate.getEmail();
        String candidateName=candidate.getFirstName();
        String companyName=jobPost.getCompany().getName();
        String role=jobPost.getRole();
        sendEmailService.zoomNotificationEmail(email,candidateName,companyName,role,duration,time,url);
        jobApplicationRepository.save(jobApplication);


    }

    public JobApplication reject(String jobApplicationId) throws IOException {
        JobApplication application = jobApplicationRepository.findById(jobApplicationId).get();
        application.setStatus(Status.REJECT);
        JobApplication updatedJob = jobApplicationRepository.save(application);
        sendEmailService.sendEmail(updatedJob);
        return updatedJob;
    }
}
