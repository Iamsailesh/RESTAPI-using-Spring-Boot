package com.jp.practicerest.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UPLOAD_DIR = "src/main/resources/static/images";
	
	public boolean uploadFile(MultipartFile mf) {
		boolean res = false;
		try {
			  File uploadDir = new File(UPLOAD_DIR);
	            if (!uploadDir.exists()) {
	                uploadDir.mkdirs();
	            }
			Files.copy(mf.getInputStream(), Path.of(UPLOAD_DIR + File.separator + mf.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			// Update the result variable to true after a successful file upload
			res = true;
			System.out.println("File uploaded successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
