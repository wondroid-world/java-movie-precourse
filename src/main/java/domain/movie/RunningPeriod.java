package domain.movie;

import java.time.LocalDate;

public record RunningPeriod(
        LocalDate openingDay,
        LocalDate closingDay
) {
    public boolean isPlaying(LocalDate date) {
        final LocalDate beforeOpeningDay = openingDay.minusDays(1);
        return date.isAfter(beforeOpeningDay) && date.isBefore(closingDay);
    }
}