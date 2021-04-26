package com.cmpe282.artemis.jobportal.entities;

import com.cmpe282.artemis.jobportal.enums.FileType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Media {
    @Id
    private String id;
    private String url;
    private String description;
    private FileType fileType;
}
