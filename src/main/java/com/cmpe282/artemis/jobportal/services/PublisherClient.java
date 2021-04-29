package com.cmpe282.artemis.jobportal.services;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import com.cmpe282.artemis.jobportal.entities.SNSEvent;
import com.cmpe282.artemis.jobportal.enums.EventType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
public class PublisherClient {
    @Value("${cloud.aws.region.static}")
    private String awsRegion;

    @Value("${amazon.jobpost.sns.topic}")
    private String productSnsTopicARN;

    private AmazonSNS amazonSNS;

    @PostConstruct
    private void init(){
        amazonSNS = AmazonSNSClientBuilder.standard().withRegion(awsRegion).build();
    }
    public void publishJobPostingEvent(JobPost jobPost, EventType eventType) throws JsonProcessingException {
        SNSEvent snsEvent = new SNSEvent();
        snsEvent.setEventType(eventType);
        snsEvent.setJobPost(jobPost);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(snsEvent);
        amazonSNS.publish(productSnsTopicARN,jsonPayload);
    }
}
