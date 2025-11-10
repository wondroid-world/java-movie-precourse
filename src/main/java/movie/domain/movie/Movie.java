package movie.domain.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Movie(
        long id,
        String title,
        Long runningTime,
        RunningPeriod runningPeriod) {

    public Movie(long id,
                 String title,
                 Long runningTime,
                 LocalDate openingDay,
                 LocalDate closingDay) {
        this(id, title, runningTime, new RunningPeriod(openingDay, closingDay));
    }

    public boolean isPlaying(LocalDate date) {
        return runningPeriod.isPlaying(date);
    }

    public LocalDateTime endingTime(LocalDateTime dateTime) {
        return dateTime.plusMinutes(runningTime);
    }
}


