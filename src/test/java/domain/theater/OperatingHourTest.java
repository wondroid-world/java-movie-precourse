package domain.theater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.assertj.core.api.Assertions.assertThat;

public class OperatingHourTest {
    private OperatingHour operatingHour;
    private LocalTime openingTime;
    private LocalTime closingTime;

    @BeforeEach
    void setup() {
        openingTime = LocalTime.of(9, 0);
        closingTime = LocalTime.of(22, 0);
        operatingHour = new OperatingHour(openingTime, closingTime);
    }

    @Test
    void 상영_시간이_opeingTime보다_전이면_false를_반환한다() {
        // given
        LocalTime timeBeforeOpeningTime = openingTime.minusHours(1);

        // when
        boolean result = operatingHour.inOperation(timeBeforeOpeningTime);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 상영_시간이_opeingTime보다_후이면_true를_반환한다() {
        // given
        LocalTime timeAfterOpeningTime = openingTime.plusHours(1);

        // when
        boolean result = operatingHour.inOperation(timeAfterOpeningTime);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 상영_시간이_closingTime보다_전이면_true를_반환한다() {
        // given
        LocalTime timeBeforeClosingTime = closingTime.minusHours(1);

        // when
        boolean result = operatingHour.inOperation(timeBeforeClosingTime);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 상영_시간이_closingTime보다_후이면_false를_반환한다() {
        // given
        LocalTime timeAfterClosingTime = closingTime.plusHours(1);

        // when
        boolean result = operatingHour.inOperation(timeAfterClosingTime);

        // then
        assertThat(result).isFalse();
    }
}
