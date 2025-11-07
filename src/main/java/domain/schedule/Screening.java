package domain.schedule;

import domain.movie.Movie;
import domain.theater.Theater;

import java.time.LocalDateTime;

public class Screening {
    private final long id;
    private final Movie movie;
    private final Theater theater;
    private final LocalDateTime startTime;

    private static final String ERROR_NOT_PLAYING = "영화 상영 가능 기간이 아닙니다.";
    private static final String ERROR_THEATER_CLOSED = "상영관 운영시간이 아닙니다.";

    public Screening(long id, Movie movie, Theater theater, LocalDateTime startTime) {
        if (!movie.isPlaying(startTime.toLocalDate())) {
            throw new IllegalArgumentException(ERROR_NOT_PLAYING);
        }
        if (!theater.inOperation(startTime.toLocalTime())) {
            throw new IllegalArgumentException(ERROR_THEATER_CLOSED);
        }

        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return movie.endingTime(startTime);
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public long getId() {
        return id;
    }
}
