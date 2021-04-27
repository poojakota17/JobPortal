package com.cmpe282.artemis.jobportal.services;

import java.util.UUID;

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

	@Autowired
	UploadAmazonClient amazonClient;

	@Autowired
	private MediaRepository mediaRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	public MediaService(MediaRepository mediaRepository) {
		this.mediaRepository = mediaRepository;
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

}
