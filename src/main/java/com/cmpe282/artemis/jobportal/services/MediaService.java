package com.cmpe282.artemis.jobportal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cmpe282.artemis.jobportal.entities.Company;
import com.cmpe282.artemis.jobportal.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cmpe282.artemis.jobportal.entities.Candidate;
import com.cmpe282.artemis.jobportal.entities.Media;
import com.cmpe282.artemis.jobportal.enums.FileType;
import com.cmpe282.artemis.jobportal.repositories.CandidateRepository;
import com.cmpe282.artemis.jobportal.repositories.MediaRepository;

@Service
public class MediaService {

	private UploadAmazonClient amazonClient;
	private MediaRepository mediaRepository;
	private CandidateRepository candidateRepository;
	private CompanyRepository companyRepository;

	@Autowired
	public MediaService(UploadAmazonClient amazonClient, MediaRepository mediaRepository, CandidateRepository candidateRepository, CompanyRepository companyRepository) {
		this.amazonClient = amazonClient;
		this.mediaRepository = mediaRepository;
		this.candidateRepository = candidateRepository;
		this.companyRepository = companyRepository;
	}

	public Media save(MultipartFile file, String candidateId) {
		String url = amazonClient.uploadFile(file);
		Media media = new Media();
		media.setUrl(url);
		media.setId(UUID.randomUUID().toString());
		media.setFileType(FileType.RESUME);
		Media newMedia = mediaRepository.save(media);
		Candidate candidate = candidateRepository.findById(candidateId).get();
		candidate.setResume(media);
		candidateRepository.save(candidate);
		return newMedia;
	}

    public List<Media> saveCompanyMedia(MultipartFile[] images, String companyId) {
		List<Media> mediaList = new ArrayList<>();
		for(MultipartFile image: images) {
			String url = amazonClient.uploadFile(image);
			Media media = new Media();
			media.setUrl(url);
			media.setId(UUID.randomUUID().toString());
			media.setFileType(FileType.IMAGE);
			mediaList.add(mediaRepository.save(media));
		}
		Company company = companyRepository.findById(companyId).get();
		company.setMediaList(mediaList);
		companyRepository.save(company);
		return mediaList;
    }

    public Media saveProfilePic(MultipartFile file, String candidateId) {
		String url = amazonClient.uploadFile(file);
		Media media = new Media();
		media.setUrl(url);
		media.setId(UUID.randomUUID().toString());
		media.setFileType(FileType.IMAGE);
		Media newMedia = mediaRepository.save(media);
		Candidate candidate = candidateRepository.findById(candidateId).get();
		candidate.setProfilePicture(media);
		candidateRepository.save(candidate);
		return newMedia;
    }
}
