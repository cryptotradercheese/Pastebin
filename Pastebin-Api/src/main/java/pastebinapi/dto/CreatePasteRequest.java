package pastebinapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.constraints.NotNull;
import pastebinapi.model.PasteExposure;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@ToString
public class CreatePasteRequest {
    @JsonProperty(defaultValue = "untitled")
    @JsonSetter(nulls = Nulls.SKIP)
    @NotNull
    @Length(min = 1, max = 100)
    private String title = "untitled";

    @JsonProperty
    @NotNull
    @Length(min = 1, max = 512 * 1024)
    private String content;

    @JsonProperty(defaultValue = "never")
    @JsonSetter(nulls = Nulls.SKIP)
    @NotNull
    private PasteExpiration expiration = PasteExpiration.NEVER;

    @JsonProperty(defaultValue = "public")
    @JsonSetter(nulls = Nulls.SKIP)
    @NotNull
    private PasteExposure exposure = PasteExposure.PUBLIC;

//    @JsonProperty(defaultValue = "None")
//    @JsonSetter(nulls = Nulls.SKIP)
//    @NotNull
//    private String category = "None";
//
//    @JsonProperty(defaultValue = "None")
//    @JsonSetter(nulls = Nulls.SKIP)
//    @NotNull
//    private String syntax = "None";
//
//    @JsonProperty(defaultValue = "[]")
//    @JsonSetter(nulls = Nulls.SKIP)
//    @NotNull
//    private final Set<Object> tags = new HashSet<>();
//
//    @JsonProperty
//    private String folder;
//
//    @JsonProperty
//    private String password;
}
