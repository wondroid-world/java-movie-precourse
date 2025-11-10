package domain.seat;

import movie.domain.seat.Row;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {
    @ParameterizedTest
    @ValueSource(chars = {'a', 'p', 'Z'})
    void 행은_A부터_P사이의_알파벳_대문자이다(char value) {
        assertThrows(IllegalArgumentException.class, () -> new Row(value));
    }
}
