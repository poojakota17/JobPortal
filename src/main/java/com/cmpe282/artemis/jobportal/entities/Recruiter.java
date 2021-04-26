package com.cmpe282.artemis.jobportal.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Recruiter {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
