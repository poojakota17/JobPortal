package com.cmpe282.artemis.jobportal.entities;

import com.cmpe282.artemis.jobportal.entities.DTO.JobPostAndCandidateDto;
import com.cmpe282.artemis.jobportal.enums.EventType;

import lombok.Data;

@Data
public class SNSEventForJobPostAndCandidate {
	JobPostAndCandidateDto jobPostAndCandidateDto;
	EventType eventType;
}