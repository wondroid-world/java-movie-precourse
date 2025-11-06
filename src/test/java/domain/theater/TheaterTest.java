package domain.theater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.assertj.core.api.Assertions.assertThat;

public class TheaterTest {
    private Theater theater;
    private LocalTime openingTime;
    private LocalTime closingTime;

    @BeforeEach
    void setup() {
        openingTime = LocalTime.of(9, 0);
        closingTime = LocalTime.of(22, 0);
        theater = new Theater(1L, openingTime, closingTime);
    }

    @Test
    @DisplayName("상영관의 시간이 opeingTime보다 전이면, false를 반환한다.")
    void isNotOperatedBeforeOpeningTime() {
        // given
        LocalTime timeBeforeOpeningTime = openingTime.minusHours(1);

        // when
        boolean result = theater.inOperation(timeBeforeOpeningTime);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("상영관의 시간이 opeingTime보다 후이면, true를 반환한다.")
    void isOperatedAfterOpeningTime() {
        // given
        LocalTime timeAfterOpeningTime = openingTime.plusHours(1);

        // when
        boolean result = theater.inOperation(timeAfterOpeningTime);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("상영관의 시간이 closingTime보다 전이면, true를 반환한다.")
    void isNotOperatedBeforeClosingTime() {
        // given
        LocalTime timeBeforeClosingTime = closingTime.minusHours(1);

        // when
        boolean result = theater.inOperation(timeBeforeClosingTime);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("상영관의 시간이 closingTime보다 전이면, true를 반환한다.")
    void isNotOperatedAfterClosingTime() {
        // given
        LocalTime timeAfterClosingTime = closingTime.plusHours(1);

        // when
        boolean result = theater.inOperation(timeAfterClosingTime);

        // then
        assertThat(result).isFalse();
    }
}
