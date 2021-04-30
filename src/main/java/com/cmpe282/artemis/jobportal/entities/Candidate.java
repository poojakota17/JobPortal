package com.cmpe282.artemis.jobportal.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Candidate {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @OneToOne
    private Media resume;
    @OneToOne
    private Media profilePicture;
    @OneToMany
    private List<Education> educationList = new ArrayList<>();
    @OneToMany
    private List<WorkHistory> workHistoryList = new ArrayList<>();
    @OneToMany
    private List<SkillSet> skillSetList = new ArrayList<>();
}
