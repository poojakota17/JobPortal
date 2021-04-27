package com.cmpe282.artemis.jobportal.entities;

import com.cmpe282.artemis.jobportal.enums.JobType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Company company;
    @OneToOne
    @JsonIgnore
    private Recruiter recruiter;
}
