package domain.schedule;

import domain.movie.Movie;
import domain.theater.Theater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static domain.fixture.Fixture.MOVIE;
import static domain.fixture.Fixture.THEATER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScreeningTest {

    @Test
    @DisplayName("영화가 상영 가능 기간이고 상영관이 운영 중이면 생성된다")
    void create_screening_success() {
        // given
        Movie playingMovie = MOVIE;
        Theater openTheater = THEATER;

        LocalDateTime startTime = LocalDateTime.of(2025, 11, 10, 10, 0);

        // when
        Screening screening = new Screening(1L, playingMovie, openTheater, startTime);

        // then
        assertThat(screening.getStartTime()).isEqualTo(startTime);
        assertThat(screening.getMovie()).isEqualTo(playingMovie);
        assertThat(screening.getTheater()).isEqualTo(openTheater);
        assertThat(screening.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("영화가 상영 가능 기간이 아니면 예외를 던진다")
    void create_screening_fail_when_movie_not_playing() {
        // given
        Movie notPlayingMovie = new Movie(
                1L,
                "극장판 체인소 맨: 레제편",
                120L,
                LocalDate.of(2025, 10, 1),
                LocalDate.of(2025, 10, 30)
        );
        Theater openTheater = THEATER;

        LocalDateTime startTime = LocalDateTime.of(2025, 11, 10, 10, 0);

        // when & then
        assertThatThrownBy(() -> new Screening(1L, notPlayingMovie, openTheater, startTime))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상영관이 운영 시간이 아니면 예외를 던진다")
    void create_screening_fail_when_theater_closed() {
        // given
        Movie playingMovie = MOVIE;
        Theater closedTheater = THEATER;

        LocalDateTime startTime = LocalDateTime.of(2025, 11, 10, 23, 0);

        // when & then
        assertThatThrownBy(() -> new Screening(1L, playingMovie, closedTheater, startTime))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("getEndTime은 영화 러닝타임만큼 더한 시간을 반환한다")
    void get_end_time() {
        // given
        long runningTime = 120L;
        Movie playingMovie = new Movie(
                1L,
                "극장판 체인소 맨: 레제편",
                runningTime,
                LocalDate.of(2025, 11, 1),
                LocalDate.of(2025, 11, 30)
        );
        Theater openTheater = THEATER;

        LocalDateTime startTime = LocalDateTime.of(2025, 11, 10, 10, 0);
        Screening screening = new Screening(1L, playingMovie, openTheater, startTime);

        // when
        LocalDateTime endTime = screening.getEndTime();

        // then
        assertThat(endTime).isEqualTo(startTime.plusMinutes(runningTime));
    }
}