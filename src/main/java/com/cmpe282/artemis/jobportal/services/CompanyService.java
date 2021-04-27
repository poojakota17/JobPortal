package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.entities.Media;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import com.cmpe282.artemis.jobportal.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private MediaRepository mediaRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, MediaRepository mediaRepository) {
        this.companyRepository = companyRepository;
        this.mediaRepository = mediaRepository;
    }

    public Company save(Company company) {
        company.setCompanyId(UUID.randomUUID().toString());
        List<Media> mediaList = company.getMediaList();
            for(Media media : mediaList){
                media.setId(UUID.randomUUID().toString());
                mediaRepository.save(media);
            }
        return companyRepository.save(company);
    }

}
