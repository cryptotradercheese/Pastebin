package pastebinapi.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pastebinapi.repository.ContentRepository;

@Configuration
public class MinioConfig {
    @Value("${spring.data.minio.host}")
    private String minioHost;

    @Value("${spring.data.minio.port}")
    private int minioPort;

    @Value("${spring.data.minio.login}")
    private String minioLogin;

    @Value("${spring.data.minio.password}")
    private String minioPassword;

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://" + minioHost + ":" + minioPort)
                .credentials(minioLogin, minioPassword)
                .build();

        try {
            BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder()
                    .bucket(ContentRepository.BUCKET_NAME)
                    .build();
            if (!minioClient.bucketExists(bucketExistsArgs)) {
                minioClient.makeBucket(
                        MakeBucketArgs
                                .builder()
                                .bucket(ContentRepository.BUCKET_NAME)
                                .build()
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return minioClient;
    }
}
