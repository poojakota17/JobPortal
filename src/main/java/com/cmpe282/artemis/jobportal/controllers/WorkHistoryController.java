package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.WorkHistory;
import com.cmpe282.artemis.jobportal.services.WorkHistoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/{candidateId}/work_history")
public class WorkHistoryController {

    private WorkHistoryService workHistoryService;

    public WorkHistoryController(WorkHistoryService workHistoryService) {
        this.workHistoryService = workHistoryService;
    }

    @PostMapping
    public WorkHistory save(@PathVariable String candidateId, @RequestBody WorkHistory workHistory){
        return workHistoryService.save(candidateId, workHistory);
    }
}
