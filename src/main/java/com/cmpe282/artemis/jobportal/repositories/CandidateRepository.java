package com.cmpe282.artemis.jobportal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cmpe282.artemis.jobportal.entities.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, String>{

}
