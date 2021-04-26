package com.cmpe282.artemis.jobportal.entities;

import com.cmpe282.artemis.jobportal.enums.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
public class JobApplication {
    @Id
    private String id;
    @OneToOne
    private Candidate candidate;
    @OneToOne
    private JobPost jobPost;
    private Status status;
    private LocalDate appliedDate;
}
