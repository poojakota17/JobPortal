package com.cmpe282.artemis.jobportal.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SkillSet {
    @Id
    private String id;
    private String skill;
}
