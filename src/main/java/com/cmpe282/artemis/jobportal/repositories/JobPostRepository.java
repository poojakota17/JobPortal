package com.cmpe282.artemis.jobportal.repositories;

import com.cmpe282.artemis.jobportal.entities.JobPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends CrudRepository<JobPost, String> {
}
