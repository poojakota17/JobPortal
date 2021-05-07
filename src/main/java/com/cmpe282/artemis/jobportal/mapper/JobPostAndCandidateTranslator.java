package com.cmpe282.artemis.jobportal.mapper;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.cmpe282.artemis.jobportal.entities.DTO.JobPostAndCandidateDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobPostAndCandidateTranslator implements DynamoDBTypeConverter<String, JobPostAndCandidateDto> {

	private static final ObjectMapper mapper = new ObjectMapper();

	@Override
	public JobPostAndCandidateDto unconvert(String s) {
		try {
			mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			return mapper.readValue(s, JobPostAndCandidateDto.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String convert(JobPostAndCandidateDto object) {
		return null;
	}
}
