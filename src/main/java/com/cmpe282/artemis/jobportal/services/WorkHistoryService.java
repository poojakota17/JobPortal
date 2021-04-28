package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.WorkHistory;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.WorkHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkHistoryService {

    private WorkHistoryRepository workHistoryRepository;
    private CandidateRepository candidateRepository;

    public WorkHistoryService(WorkHistoryRepository workHistoryRepository, CandidateRepository candidateRepository) {
        this.workHistoryRepository = workHistoryRepository;
        this.candidateRepository = candidateRepository;
    }

    public WorkHistory save(String candidateId, WorkHistory workHistory){
        workHistory.setId(UUID.randomUUID().toString());
        WorkHistory workHistory1 = workHistoryRepository.save(workHistory);
        Candidate candidate = candidateRepository.findById(candidateId).get();
        List<WorkHistory> workHistoryList = candidate.getWorkHistoryList();
        workHistoryList.add(workHistory1);
        candidate.setWorkHistoryList(workHistoryList);
        candidateRepository.save(candidate);
        return workHistory1;
    }
}
