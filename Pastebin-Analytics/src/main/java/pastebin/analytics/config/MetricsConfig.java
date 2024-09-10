package pastebin.analytics.config;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import pastebin.analytics.service.MetricsService;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class MetricsConfig {
    @Value("${management.prometheus.metrics.export.pushgateway.base-url}")
    private String pushGatewayUrl;

    @Autowired
    public void setCustomMetric(MeterRegistry meterRegistry, @Lazy MetricsService metricsService) {
        Gauge.builder("default_titles_ratio", metricsService::getDefaultTitlesRatio)
                .description("The ratio of pastes with unmodified titles to pastes with modified titles")
                .register(meterRegistry);
    }

    @Bean
    public CollectorRegistry registry() {
        return new CollectorRegistry();
    }

    @Bean
    public io.prometheus.client.Gauge gauge(CollectorRegistry registry) {
        return io.prometheus.client.Gauge.build()
                .name("default_titles_ratio")
                .help("The ratio of pastes with unmodified titles to pastes with modified titles")
                .register(registry);
    }

    @Bean
    public PushGateway pushGateway() throws MalformedURLException {
        return new PushGateway(new URL(pushGatewayUrl));
    }
}
