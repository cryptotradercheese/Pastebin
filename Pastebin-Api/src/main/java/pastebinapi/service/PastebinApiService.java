package pastebinapi.service;

import pastebinapi.config.KafkaProducerConfig;
import pastebinapi.model.PasteMetadata;
import pastebinapi.dto.CreatePasteRequest;
import pastebinapi.repository.ContentRepository;
import pastebinapi.repository.MetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PastebinApiService {
    private MetaDataRepository metaDataRepository;
    private ContentRepository contentRepository;
    private PasteIdClient pasteIdClient;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PastebinApiService(MetaDataRepository metaDataRepository, ContentRepository contentRepository,
                              PasteIdClient pasteIdClient, KafkaTemplate<String, String> kafkaTemplate) {
        this.metaDataRepository = metaDataRepository;
        this.contentRepository = contentRepository;
        this.pasteIdClient = pasteIdClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public String createPaste(CreatePasteRequest request) {
        sendMetric(request.getTitle());

        String id = pasteIdClient.requestPasteId();
        PasteMetadata pasteMetadata = PasteMetadata.builder()
                .id(id)
                .title(request.getTitle())
                .published(LocalDateTime.now())
                .expiration(request.getExpiration().getDuration())
                .exposure(request.getExposure())
                .build();
        contentRepository.save(id, request.getContent());
        metaDataRepository.save(pasteMetadata);

        return id;
    }

    private void sendMetric(String pasteTitle) {
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, pasteTitle);
    }

    @Cacheable(cacheNames = "content", cacheManager = "contentCacheManager")
    public Optional<String> getPasteContent(String id) {
        return contentRepository.findById(id);
    }

    @Cacheable(cacheNames = "metadata", cacheManager = "metadataCacheManager")
    public Optional<PasteMetadata> getPasteMetadata(String id) {
        return metaDataRepository.findById(id);
    }
}
