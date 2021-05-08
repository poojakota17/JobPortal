package com.cmpe282.artemis.jobportal.repositories;

import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.enums.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends CrudRepository<JobApplication, String> {
    Iterable<JobApplication> findByCandidateId(String candidateId);
    Iterable<JobApplication> findByJobPostIdAndStatusEquals(String jobPostId, Status status);
}
