package com.cmpe282.artemis.jobportal.entities.DTO;

import java.util.List;

import javax.persistence.Id;

import com.cmpe282.artemis.jobportal.entities.SkillSet;
import com.cmpe282.artemis.jobportal.enums.JobType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobPostAndCandidateDto {
		@Id
		private String id;
	 	private String jobPostId;
	    private String title;
	    private String role;
	    private String description;
	    private JobType jobType;
	    private List<SkillSet> skillSetList;
	    private String candidateId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phone;
	    private String resumeUrl;
	    private String scores;
}