package com.cmpe282.artemis.jobportal.entities;

import com.cmpe282.artemis.jobportal.enums.Industry;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Company {
    @Id
    private String companyId;
    private String name;
    private Industry industry;
    private String about;
    private String websiteUrl;
    @OneToMany
    private List<Media> mediaList;
}
