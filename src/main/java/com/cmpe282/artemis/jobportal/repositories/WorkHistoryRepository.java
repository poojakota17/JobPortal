package com.cmpe282.artemis.jobportal.repositories;

import com.cmpe282.artemis.jobportal.entities.WorkHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHistoryRepository extends CrudRepository<WorkHistory, String> {
}
