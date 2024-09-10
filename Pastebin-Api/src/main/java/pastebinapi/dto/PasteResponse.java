package pastebinapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pastebinapi.model.PasteExposure;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class PasteResponse {
    @JsonProperty
    private String title;

    @JsonProperty
    private String content;

    @JsonProperty
    private PasteExpiration expiration;

    @JsonProperty
    private PasteExposure exposure;

    @JsonProperty
    private LocalDateTime published;

//    @JsonProperty
//    private String author;
//
//    @JsonProperty
//    private long visits;
//
//    @JsonProperty
//    private long rating;
//
//    @JsonProperty
//    private List<String> comments;
//
//    @JsonProperty
//    private String syntax;
//
//    @JsonProperty
//    private long size;
//
//    @JsonProperty
//    private String category;
//
//    @JsonProperty
//    private long likes;
//
//    @JsonProperty
//    private long dislikes;
//
//    @JsonProperty
//    private Set<Object> tags;
}
