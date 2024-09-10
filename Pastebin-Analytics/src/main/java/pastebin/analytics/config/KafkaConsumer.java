package pastebin.analytics.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pastebin.analytics.service.MetricsService;

@Component
public class KafkaConsumer {
    private MetricsService metricsService;

    @Autowired
    public KafkaConsumer(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @KafkaListener(topics = "titles", groupId = KafkaConsumerConfig.GROUP_ID)
    public void listenMyGroupId(ConsumerRecord<String, String> message) {
        metricsService.setDefaultTitlesRatio(message.value());
    }
}
