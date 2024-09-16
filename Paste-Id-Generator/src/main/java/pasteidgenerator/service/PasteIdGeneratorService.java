package pasteidgenerator.service;

import pasteidgenerator.repository.NumberGeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;

@Service
public class PasteIdGeneratorService {
    private static final int INCREMENT = 100;
    private long generator;
    private final Base64.Encoder encoder;
    private final NumberGeneratorRepository numberGeneratorRepository;

    @Autowired
    public PasteIdGeneratorService(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
        generator = 1;
        encoder = Base64.getUrlEncoder().withoutPadding();
    }

    public String generate() {
        long number = generateNumber();
        return encode(number);
    }

    private synchronized long generateNumber() {
        if (generator % INCREMENT == 1) {
            generator = numberGeneratorRepository.nextVal();
        }
        return generator++;
    }

    private String encode(long number) {
        byte[] bytes = ByteBuffer.allocate(Long.BYTES)
                .putLong(number)
                .array();
        return encoder.encodeToString(bytes);
    }
}