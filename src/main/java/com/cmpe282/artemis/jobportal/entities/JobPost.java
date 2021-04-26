package com.cmpe282.artemis.jobportal.entities;

import com.cmpe282.artemis.jobportal.enums.JobType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class JobPost {
    @Id
    private String id;
    private String title;
    private String role;
    private String description;
    private String location;
    private JobType jobType;
    private LocalDate expiry;
    @OneToMany
    private List<SkillSet> skillSetList;
    @OneToOne
    private Recruiter recruiter;
}
