package com.example.demo.controller;

import com.example.demo.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class testController {
    @Autowired
    public S3Service s3Service;

    @PostMapping("/test")
    public String uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        return s3Service.uploadFile(file.getInputStream(), file.getOriginalFilename(), file);
    }
}
