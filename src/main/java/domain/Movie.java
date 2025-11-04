package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Movie {
    private final String title;
    private final Long runningTime;
    private final LocalDate openingDay;
    private final LocalDate closingDay;

    public Movie(String title, Long runningTime, LocalDate openingDay, LocalDate closingDay) {
        this.title = title;
        this.runningTime = runningTime;
        this.openingDay = openingDay;
        this.closingDay = closingDay;
    }

    public String getTitle() {
        return title;
    }

    public long getRunningTime() {
        return runningTime;
    }

    public LocalDate getOpeningDay() {
        return openingDay;
    }

    public LocalDate getClosingDay() {
        return closingDay;
    }

    public boolean isPlaying(LocalDate date) {
        final LocalDate beforeOpeningDay = openingDay.minusDays(1);
        return date.isAfter(beforeOpeningDay) && date.isBefore(closingDay);
    }

    public LocalDateTime endingTime(LocalDateTime dateTime) {
        return dateTime.plusMinutes(runningTime);
    }
}
