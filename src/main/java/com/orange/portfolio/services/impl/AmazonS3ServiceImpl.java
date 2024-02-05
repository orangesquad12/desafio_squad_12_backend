package com.orange.portfolio.services.impl;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.orange.portfolio.configuration.AwsS3Configuration;
import com.orange.portfolio.services.AmazonS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class AmazonS3ServiceImpl implements AmazonS3Service {

    @Autowired
    private AwsS3Configuration awsS3Config;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Value("${aws.s3.endpointUrl}")
    private String endpointUrl;

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String fileUrl = "";
        try{
            File file = convertMultiPartFileToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = awsS3Config.amazonS3Client().getUrl(bucketName, fileName).toString();
            uploadFileToS3Bucket(fileName, file);
            file.delete();
        } catch(Exception e){
            e.printStackTrace();
        }
        return fileUrl;
    }

    @Override
    public void deleteFileFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        awsS3Config.amazonS3Client().deleteObject(
                new DeleteObjectRequest(bucketName + "/", fileName)
        );

    }

    @Override
    public void uploadFileToS3Bucket(String fileName, File file) {
        awsS3Config.amazonS3Client().
                putObject(new PutObjectRequest(bucketName, fileName, file)
                        .withCannedAcl(CannedAccessControlList.PublicRead));

    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertedFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

}
