package com.cmpe282.artemis.jobportal.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.entities.DTO.JobPostAndCandidateDto;
import com.cmpe282.artemis.jobportal.mapper.JobPostAndCandidateTranslator;
import com.cmpe282.artemis.jobportal.repositories.JobApplicationRepository;

@Service
public class JobPostAndCandidateService {

	@Value("${amazon.dynamodb.accesskey}")
	private String amazonDynamoDBAccessKey;

	@Value("${amazon.dynamodb.secretkey}")
	private String amazonDynamoDBSecretKey;

	private AmazonDynamoDB client;

	private JobApplicationRepository jobApplicationRepository;

	private JobPostAndCandidateTranslator jobPostAndCandidateTranslator;

	private JobPostAndCandidateDto jobPostAndCandidateDto;

	public JobPostAndCandidateService(JobApplicationRepository jobApplicationRepository,
			JobPostAndCandidateTranslator jobPostAndCandidateTranslator) {
		this.jobApplicationRepository = jobApplicationRepository;
		this.jobPostAndCandidateTranslator = jobPostAndCandidateTranslator;
	}

	@PostConstruct
	private void init() {
		client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials(amazonDynamoDBAccessKey, amazonDynamoDBSecretKey)))
				.withRegion(Regions.US_EAST_1).build();
	}

	public JobPostAndCandidateDto findScoreForAJobPost(String jobApplicationId) {
		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("JobPostAndCandidate");
		JobApplication jobApplication = jobApplicationRepository.findById(jobApplicationId).get();
		String candidateId = jobApplication.getCandidate().getId();
		String jobPostId = jobApplication.getJobPost().getId();

		GetItemSpec spec = new GetItemSpec().withPrimaryKey("candidateId", candidateId, "jobPostId", jobPostId);
		try {
			System.out.println("Attempting to read the item...");
			Item outcome = table.getItem(spec);
			System.out.println("GetItem succeeded: " + outcome);
			jobPostAndCandidateDto = jobPostAndCandidateTranslator.unconvert(outcome.toJSON());
		} catch (Exception e) {
			System.err.println("Unable to read item: ");
			System.err.println(e.getMessage());
		}

		return jobPostAndCandidateDto;

	}

}
