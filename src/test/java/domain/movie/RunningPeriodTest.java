package domain.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RunningPeriodTest {
    private RunningPeriod runningPeriod;

    @BeforeEach
    void setup() {
        runningPeriod = new RunningPeriod(
                LocalDate.now(),
                LocalDate.now().plusDays(30
        ));
    }

    @Test
    @DisplayName("영화가 상영중이면, true를 반환한다.")
    void isPlayingNow() {
        // given
        LocalDate today = LocalDate.now();

        // when
        boolean result = runningPeriod.isPlaying(today);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("영화가 상영이 끝나면, false를 반환한다.")
    void isNotPlayingNow() {
        // given
        LocalDate closedDay = LocalDate.now().plusDays(31);

        // when
        boolean result = runningPeriod.isPlaying(closedDay);

        // then
        assertThat(result).isFalse();
    }

}
