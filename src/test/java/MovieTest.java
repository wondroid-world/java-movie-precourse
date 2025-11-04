import domain.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    void setup() {
        movie = new Movie(
                "극장판 체인소 맨: 레제편",
                120L,
                LocalDate.now(),
                LocalDate.now().plusDays(30)
        );
    }

    @Test
    @DisplayName("영화가 상영중이면, true를 반환한다.")
    void isPlayingNow() {
        // given
        LocalDate today = LocalDate.now();

        // when
        boolean result = movie.isPlaying(today);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("영화가 상영이 끝나면, false를 반환한다.")
    void isNotPlayingNow() {
        // given
        LocalDate closedDay = LocalDate.now().plusDays(31);

        // when
        boolean result = movie.isPlaying(closedDay);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("영화가 끝나는 시간을 반환한다.")
    void endingTime() {
        // given
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expected = now.plusMinutes(movie.runningTime());

        // when
        LocalDateTime result = movie.endingTime(now);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
