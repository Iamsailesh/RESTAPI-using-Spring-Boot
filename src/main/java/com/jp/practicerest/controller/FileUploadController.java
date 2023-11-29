package com.jp.practicerest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jp.practicerest.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("img1") MultipartFile img1) {
        try {
            if (img1.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Request must contain a file");
            }

//            if (!img1.getContentType().equals("image/jpg")) {
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Only jpg image accepted");
//            }

            // File upload code
            boolean isFileUploaded = fileUploadHelper.uploadFile(img1);
            if (isFileUploaded) {
                return ResponseEntity.ok("File is successfully uploaded");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during file upload");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during file upload");
        }
    }
}
