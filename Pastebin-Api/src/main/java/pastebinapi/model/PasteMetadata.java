package pastebinapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "pastes_metadata")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PasteMetadata implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "published", nullable = false)
    private LocalDateTime published;

    @Column(name = "expiration", nullable = false, precision = 40)
    private Duration expiration;

    @Column(name = "exposure", nullable = false)
    @Enumerated(EnumType.STRING)
    private PasteExposure exposure;
}
