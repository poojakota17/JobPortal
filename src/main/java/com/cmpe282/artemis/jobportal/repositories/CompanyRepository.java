package com.cmpe282.artemis.jobportal.repositories;

import com.cmpe282.artemis.jobportal.entities.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
}