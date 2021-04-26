package com.cmpe282.artemis.jobportal.entities.DTO;

import com.cmpe282.artemis.jobportal.entities.JobApplication;
import com.cmpe282.artemis.jobportal.entities.JobPost;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobView {
    private JobPost jobPost;
    private LocalDateTime lastAppliedDateTime;
}
