package pastebinapi.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import pasteidgenerator.proto.PasteIdGeneratorGrpc;
import pasteidgenerator.proto.PasteIdRequest;

@Service
public class PasteIdClient {
    @GrpcClient("pasteidgenerator")
    private PasteIdGeneratorGrpc.PasteIdGeneratorBlockingStub stub;

    public String requestPasteId() {
        PasteIdRequest request = PasteIdRequest.newBuilder().build();
        return stub.generate(request).getPasteId();
    }
}
