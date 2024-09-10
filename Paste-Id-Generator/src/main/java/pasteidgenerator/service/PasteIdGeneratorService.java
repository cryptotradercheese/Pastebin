package pasteidgenerator.service;

import pasteidgenerator.repository.NumberGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PasteIdGeneratorService {
    private static final int INCREMENT = 100;
    private final Semaphore semaphore;
    private final AtomicLong generator;
    private final Base64.Encoder encoder;
    private final NumberGeneratorRepository numberGeneratorRepository;

    @Autowired
    public PasteIdGeneratorService(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
        semaphore = new Semaphore(INCREMENT);
        generator = new AtomicLong(numberGeneratorRepository.nextVal());
        encoder = Base64.getUrlEncoder().withoutPadding();
    }

    public String generate() {
        long number = generateNumber();
        return encode(number);
    }

    private long generateNumber() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long number = generator.getAndIncrement();
        if (semaphore.availablePermits() == 0) {
            generator.set(numberGeneratorRepository.nextVal());
            semaphore.release(INCREMENT);
        }
        return number;
    }

    private String encode(long number) {
        byte[] bytes = ByteBuffer.allocate(Long.BYTES)
                .putLong(number)
                .array();
        return encoder.encodeToString(bytes);
    }
}