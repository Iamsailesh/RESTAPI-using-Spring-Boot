package com.jp.practicerest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("img1") MultipartFile img1){
//		System.out.println(img1.getOriginalFilename());
//		System.out.println(img1.getSize());
//		System.out.println(img1.getName());
//		
//		validation
		if(img1.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}if(!img1.getContentType().equals("img1/jpeg")){
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg image accepted");

		}
		
		return ResponseEntity.ok("WOw");
		
	}

}
