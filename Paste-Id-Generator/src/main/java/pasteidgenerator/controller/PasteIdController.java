package pasteidgenerator.controller;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import pasteidgenerator.proto.PasteIdGeneratorGrpc;
import pasteidgenerator.proto.PasteIdRequest;
import pasteidgenerator.proto.PasteIdResponse;
import pasteidgenerator.service.PasteIdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PasteIdController extends PasteIdGeneratorGrpc.PasteIdGeneratorImplBase {
    private PasteIdGeneratorService pasteIdGeneratorService;

    @Autowired
    public PasteIdController(PasteIdGeneratorService pasteIdGeneratorService) {
        this.pasteIdGeneratorService = pasteIdGeneratorService;
    }

    @Override
    public void generate(PasteIdRequest request, StreamObserver<PasteIdResponse> responseObserver) {
        PasteIdResponse response = PasteIdResponse.newBuilder()
                .setPasteId(pasteIdGeneratorService.generate())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
