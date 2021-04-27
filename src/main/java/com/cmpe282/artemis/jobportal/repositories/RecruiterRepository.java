package com.cmpe282.artemis.jobportal.repositories;

import com.cmpe282.artemis.jobportal.entities.Recruiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends CrudRepository<Recruiter, String> {
    Iterable<Recruiter> findByCompanyCompanyId(String companyId);
}
