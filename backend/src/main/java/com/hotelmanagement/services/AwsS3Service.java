package com.hotelmanagement.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import com.hotelmanagement.exceptions.OurException;

@Service
public class AwsS3Service {

    private final String bucketName = "hotel-images-luismpereira";

    @Value("${aws.s3.access.key}")
    private String awsS3AccessKey;

    @Value("${aws.s3.secret.key.key}")
    private String awsS3SecretKey;

    @Value("${aws.s3.region:eu-north-1}") // O hardcodea en el código
    private String awsRegion;

    public String saveImageToS3(MultipartFile photo) {
        try {
            String s3FileName = photo.getOriginalFilename();

            // Configurar credenciales y cliente S3
            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(awsS3AccessKey, awsS3SecretKey);

            S3Client s3Client = S3Client.builder()
                    .region(Region.of(awsRegion))
                    .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                    .build();

            // Construir la petición de subida
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(s3FileName)
                    .contentType("image/jpeg")
                    .contentLength(photo.getSize())
                    .build();

            // Subir el archivo directamente desde MultipartFile InputStream
            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(photo.getInputStream(), photo.getSize()));

            s3Client.close();

            return "https://" + bucketName + ".s3.amazonaws.com/" + s3FileName;

        } catch (Exception e) {
            e.printStackTrace();
            throw new OurException("Unable to upload image to s3 bucket: " + e.getMessage());
        }
    }
}
