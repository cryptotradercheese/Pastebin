package pastebinapi.repository;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

@Repository
public class ContentRepository {
    public static final String BUCKET_NAME = "pastes-content";
    private MinioClient minioClient;

    @Autowired
    public ContentRepository(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public void save(String pasteId, String content) {
        byte[] textBytes = content.getBytes();
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(BUCKET_NAME)
                .object(pasteId)
                .stream(new ByteArrayInputStream(textBytes), textBytes.length, -1)
                .build();
        try {
            minioClient.putObject(putObjectArgs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<String> findById(String pasteId) {
        GetObjectArgs args = GetObjectArgs.builder()
                .bucket(BUCKET_NAME)
                .object(pasteId)
                .build();
        try (InputStream inputStream = minioClient.getObject(args)) {
            return Optional.of(new String(inputStream.readAllBytes()));
        } catch (ErrorResponseException e) {
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
