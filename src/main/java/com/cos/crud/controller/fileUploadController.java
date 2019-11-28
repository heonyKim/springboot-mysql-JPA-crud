package com.cos.crud.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class fileUploadController {

	@Value("${file.path}")						//@Value : *.yml 에 적혀있는걸 찾을 수 있음.(별도로 static String으로 파일경로를 만들어서 하는것과 동일)
	private String resourcePath;
	
	@PostMapping("/file/upload")
	public @ResponseBody String imageUpload(@RequestParam("file") MultipartFile file) {
		
		System.out.println("====진입");
		UUID uuid = UUID.randomUUID();
		
		String uuidFileName = uuid + "_"+file.getOriginalFilename();
		
		Path filePath = Paths.get(resourcePath+uuidFileName);
		System.out.println("filePath : " + filePath);
		
		try {
			Files.write(filePath, file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filePath.toString();
	}
	
}
