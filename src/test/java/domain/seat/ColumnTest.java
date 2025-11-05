package domain.seat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColumnTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    void 열은_1부터_45사이의_숫자이다(int value) {
        assertThrows(IllegalArgumentException.class, () -> new Column(value));
    }
}
