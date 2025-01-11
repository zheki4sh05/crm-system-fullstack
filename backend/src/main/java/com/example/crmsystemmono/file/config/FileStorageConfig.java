package com.example.crmsystemmono.file.config;
import com.example.crmsystemmono.file.dto.MinioProperties;
import io.minio.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class FileStorageConfig {
    @Autowired
    private MinioProperties minioProperties;
    @Bean
    public MinioClient minioClient() {

        return MinioClient.builder()
                .endpoint(minioProperties.getUrl())
                .credentials(minioProperties.getAccessKey(),
                        minioProperties.getSecretKey())
                .build();
    }

}
