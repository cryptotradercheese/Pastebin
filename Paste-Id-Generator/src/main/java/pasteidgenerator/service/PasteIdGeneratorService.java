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
    private volatile long maxAllowedNumber;
    private final Base64.Encoder encoder;
    private final NumberGeneratorRepository numberGeneratorRepository;

    @Autowired
    public PasteIdGeneratorService(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
        semaphore = new Semaphore(INCREMENT);
        generator = new AtomicLong(numberGeneratorRepository.nextVal());
        maxAllowedNumber = generator.get() + INCREMENT - 1;
        encoder = Base64.getUrlEncoder().withoutPadding();
    }

    public String generate() {
        long number = generateNumber();
        return encode(number);
    }

    private long generateNumber() {
        long number = generator.getAndIncrement();
        if (number > maxAllowedNumber) {
            synchronized (this) {
                if (number > maxAllowedNumber) {
                    long nextClosestIncrement = (number + INCREMENT) / INCREMENT * INCREMENT + 1;
                    numberGeneratorRepository.setVal(nextClosestIncrement);
                    maxAllowedNumber = nextClosestIncrement + INCREMENT - 1;
                }
            }
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