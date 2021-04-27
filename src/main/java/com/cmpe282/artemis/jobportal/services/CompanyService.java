package com.cmpe282.artemis.jobportal.services;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.entities.Media;
import com.cmpe282.artemis.jobportal.enums.FileType;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import com.cmpe282.artemis.jobportal.repositories.MediaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private UploadAmazonClient amazonClient;
    private CompanyRepository companyRepository;
    private MediaRepository mediaRepository;

    public CompanyService(UploadAmazonClient amazonClient, CompanyRepository companyRepository, MediaRepository mediaRepository) {
        this.amazonClient = amazonClient;
        this.companyRepository = companyRepository;
        this.mediaRepository = mediaRepository;
    }

    public Company save(String company, MultipartFile[] images) {
        Company companyJson = new Company();

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            companyJson = objectMapper.readValue(company, Company.class);
            System.out.println(companyJson);
            companyJson.setCompanyId(UUID.randomUUID().toString());
            List<Media> mediaList = new ArrayList<>();
            for(MultipartFile image: images) {
                String url = amazonClient.uploadFile(image);
                Media media = new Media();
                media.setUrl(url);
                media.setId(UUID.randomUUID().toString());
                media.setFileType(FileType.IMAGE);
                mediaList.add(mediaRepository.save(media));
            }
            companyJson.setMediaList(mediaList);
            return companyRepository.save(companyJson);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

}
