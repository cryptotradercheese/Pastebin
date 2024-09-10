package pastebinapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import pastebinapi.dto.CreatePasteRequest;
import pastebinapi.dto.PasteExpiration;
import pastebinapi.dto.PasteResponse;
import pastebinapi.model.PasteMetadata;
import pastebinapi.service.PastebinApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class PastebinApiController {
    @Value("${server.host}")
    private String serverHost;

    @Value("${server.port}")
    private int serverPort;

    private PastebinApiService pastebinApiService;

    @Autowired
    public PastebinApiController(PastebinApiService pastebinApiService) {
        this.pastebinApiService = pastebinApiService;
    }

    @Operation(
            summary = "Create a new paste and get its ID",
            responses = {
                    @ApiResponse(description = "Paste id", responseCode = "302"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
            }
    )
    @PostMapping
    public ResponseEntity<?> createPaste(@RequestBody @Valid CreatePasteRequest request) {
        String pasteId = pastebinApiService.createPaste(request);
        String location = "http://" + serverHost + ":" + serverPort + "/v1/" + pasteId;
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", location)
                .build();
    }

    @Operation(
            summary = "Get a created paste by ID",
            responses = {
                    @ApiResponse(description = "Found paste", responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(description = "Paste is not found", responseCode = "404")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<PasteResponse> getPaste(@NotNull @NotEmpty @PathVariable("id") String id) {
        PasteMetadata metadata = pastebinApiService.getPasteMetadata(id)
                .orElseThrow(NotFoundException::new);
        String content = pastebinApiService.getPasteContent(id).orElseThrow(NotFoundException::new);
        PasteResponse response = PasteResponse.builder()
                .title(metadata.getTitle())
                .content(content)
                .published(metadata.getPublished())
                .expiration(PasteExpiration.of(metadata.getExpiration()))
                .exposure(metadata.getExposure())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
