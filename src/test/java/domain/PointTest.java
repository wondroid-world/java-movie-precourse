package domain;

import movie.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    private Point point;

    @BeforeEach
    void setup() {
        point = new Point(100);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -3})
    void 포인트는_마이너스_값이_올_수_없다(int value) {
        assertThrows(IllegalArgumentException.class, () -> new Point(value));
    }

    @Test
    void 포인트는_더할_수_있다() {
        // given
        Point point1 = new Point(100);
        Point point2 = new Point(100);

        // when
        Point result = point1.plus(point2);

        // then
        assertThat(result.value()).isEqualTo(200);
    }

    @Test
    void 포인트는_뺄_수_있다() {
        // given
        Point point1 = new Point(100);
        Point point2 = new Point(100);

        // when
        Point result = point1.minus(point2);

        // then
        assertThat(result.value()).isEqualTo(0);
    }
}
