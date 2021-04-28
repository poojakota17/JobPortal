package com.cmpe282.artemis.jobportal.entities;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Education {
    @Id
    private String id;
    private String University;
    private LocalDate startDate;
    private LocalDate endDate;
    private String degree;
    private String major;
}
