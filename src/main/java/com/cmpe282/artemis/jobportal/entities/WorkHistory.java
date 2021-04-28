package com.cmpe282.artemis.jobportal.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class WorkHistory {
    @Id
    private String id;
    private String name;
    private String city;
    private String state;
    private String jobResponsibilities;
    private LocalDate startDate;
    private LocalDate endDate;
}
