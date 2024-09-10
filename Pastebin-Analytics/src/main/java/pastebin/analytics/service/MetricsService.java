package pastebin.analytics.service;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MetricsService {
    private AtomicLong defaultTitles;
    private AtomicLong totalTitles;
    private Gauge defaultTitlesRatio;
    private PushGateway pushGateway;
    private CollectorRegistry registry;

    @Autowired
    public MetricsService(Gauge defaultTitlesRatio, PushGateway pushGateway,
                          CollectorRegistry registry) {
        this.defaultTitlesRatio = defaultTitlesRatio;
        this.pushGateway = pushGateway;
        this.registry = registry;
        defaultTitles = new AtomicLong();
        totalTitles = new AtomicLong();
    }

    public double getDefaultTitlesRatio() {
        return (double) defaultTitles.get() / totalTitles.get();
    }

    public void setDefaultTitlesRatio(String title) {
        long updatedDefaultTitles;
        if ("untitled".equals(title)) {
            updatedDefaultTitles = defaultTitles.incrementAndGet();
        } else {
            updatedDefaultTitles = defaultTitles.get();
        }

        double updatedDefaultTitlesRatio = (double) updatedDefaultTitles / totalTitles.incrementAndGet();
        defaultTitlesRatio.set(updatedDefaultTitlesRatio);
        try {
            pushGateway.pushAdd(registry, "my_batch_job");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
