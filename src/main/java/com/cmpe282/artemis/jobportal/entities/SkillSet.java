package com.cmpe282.artemis.jobportal.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class SkillSet {
    @Id
    private String id;
    private String skill;
}
