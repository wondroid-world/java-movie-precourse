package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Movie(String title, Long runningTime, LocalDate openingDay, LocalDate closingDay) {

    public boolean isPlaying(LocalDate date) {
        final LocalDate beforeOpeningDay = openingDay.minusDays(1);
        return date.isAfter(beforeOpeningDay) && date.isBefore(closingDay);
    }

    public LocalDateTime endingTime(LocalDateTime dateTime) {
        return dateTime.plusMinutes(runningTime);
    }
}
