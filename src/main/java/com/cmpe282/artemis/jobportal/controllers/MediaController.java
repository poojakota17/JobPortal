package com.cmpe282.artemis.jobportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmpe282.artemis.jobportal.entities.Media;
import com.cmpe282.artemis.jobportal.services.MediaService;

@RestController
@CrossOrigin
@RequestMapping("/api/media")
public class MediaController {
	private MediaService mediaService;
	
	@Autowired
	public MediaController(MediaService mediaService) {
		this.mediaService = mediaService;
	}
	
	@PostMapping("/upload")
    public Media save(@RequestPart(value="file")MultipartFile file){
        return mediaService.save(file);
    }
}
