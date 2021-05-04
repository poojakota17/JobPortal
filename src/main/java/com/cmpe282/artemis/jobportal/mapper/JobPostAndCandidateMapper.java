package com.cmpe282.artemis.jobportal.mapper;

import org.springframework.stereotype.Component;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.entities.DTO.JobPostAndCandidateDto;

@Component
public class JobPostAndCandidateMapper {
	public JobPostAndCandidateDto mapDto(JobPost jobPost, Candidate candidate) {
		JobPostAndCandidateDto jobPostAndCandidateDto = new JobPostAndCandidateDto();
		jobPostAndCandidateDto.setJobPostId(jobPost.getId());
		jobPostAndCandidateDto.setCandidateId(candidate.getId());
		if (jobPost.getRole() != null)
			jobPostAndCandidateDto.setRole(jobPost.getRole());
		if (jobPost.getJobType() != null)
			jobPostAndCandidateDto.setJobType(jobPost.getJobType());
		if (jobPost.getDescription() != null)
			jobPostAndCandidateDto.setDescription(jobPost.getDescription());
		if (jobPost.getSkillSetList() != null)
			jobPostAndCandidateDto.setSkillSetList(jobPost.getSkillSetList());
		if (candidate.getFirstName() != null)
			jobPostAndCandidateDto.setFirstName(candidate.getFirstName());
		if (candidate.getLastName() != null)
			jobPostAndCandidateDto.setLastName(candidate.getLastName());
		if (candidate.getEmail() != null)
			jobPostAndCandidateDto.setEmail(candidate.getEmail());
		if (candidate.getPhone() != null)
			jobPostAndCandidateDto.setPhone(candidate.getPhone());
		if (candidate.getResume() != null && candidate.getResume().getUrl() != null)
			jobPostAndCandidateDto.setResumeUrl(candidate.getResume().getUrl());
		return jobPostAndCandidateDto;

	}
}
