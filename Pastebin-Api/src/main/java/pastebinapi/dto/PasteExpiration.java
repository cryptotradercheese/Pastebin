package pastebinapi.dto;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public enum PasteExpiration {
    TEN_MINUTES(ChronoUnit.MINUTES.getDuration().multipliedBy(10)),
    ONE_HOUR(ChronoUnit.HOURS.getDuration()),
    ONE_DAY(ChronoUnit.DAYS.getDuration()),
    ONE_WEEK(ChronoUnit.WEEKS.getDuration()),
    TWO_WEEKS(ChronoUnit.WEEKS.getDuration().multipliedBy(2)),
    ONE_MONTH(ChronoUnit.MONTHS.getDuration()),
    SIX_MONTHS(ChronoUnit.MONTHS.getDuration().multipliedBy(6)),
    ONE_YEAR(ChronoUnit.YEARS.getDuration()),
    NEVER(ChronoUnit.FOREVER.getDuration()),
    BURN_AFTER_READ(Duration.ZERO);

    private final Duration duration;

    PasteExpiration(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    public static PasteExpiration of(Duration duration) {
        for (PasteExpiration expiration : PasteExpiration.values()) {
            if (Objects.equals(duration, expiration.getDuration())) {
                return expiration;
            }
        }

        throw new IllegalArgumentException();
    }
}
