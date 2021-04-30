package com.cmpe282.artemis.jobportal.controllers;

import com.cmpe282.artemis.jobportal.entities.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cmpe282.artemis.jobportal.entities.Media;
import com.cmpe282.artemis.jobportal.services.MediaService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/media")
public class MediaController {
	private MediaService mediaService;
	
	@Autowired
	public MediaController(MediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@PostMapping("/candidate/{candidateId}")
    public Media save(@RequestPart(value="file")MultipartFile file, @PathVariable String candidateId){
        return mediaService.save(file, candidateId);
    }
	@PostMapping("/candidate/profilepic/{candidateId}")
	public Media saveProfilePicture(@RequestPart(value="image")MultipartFile file, @PathVariable String candidateId){
		return mediaService.saveProfilePic(file, candidateId);
	}
	@PostMapping("/company/{companyId}")
	public List<Media> save(@RequestPart(value = "images") MultipartFile[] images, @PathVariable String companyId){
		return mediaService.saveCompanyMedia(images, companyId);
	}
}
