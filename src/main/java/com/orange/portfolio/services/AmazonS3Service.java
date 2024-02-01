package com.orange.portfolio.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface AmazonS3Service {

    String uploadFile(MultipartFile multipartFile);

    void deleteFileFromS3Bucket(String fileUrl);

    void uploadFileToS3Bucket(String fileName, File file);
}
