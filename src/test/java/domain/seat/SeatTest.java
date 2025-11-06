package domain.seat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {
    private Seat seat;

    @BeforeEach
    void setup() {
        seat = new Seat('A', 1, SeatType.A);
    }

    @Test
    void 좌석을_처음_잡았을때_빈_좌석이다(){
        // given, when
        Boolean result = seat.getBook();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 좌석을_예약하면_true를_반환한다() {
        // given, when
        seat.book();
        Boolean result = seat.getBook();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 좌석을_예약을_취소하면_false를_반환한다() {
        // given
        seat.book();
        seat.cancel();

        // when
        Boolean result = seat.getBook();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 좌석의_가격을_알_수_있다() {
        // given
        int expected = SeatType.A.getPrice();

        // when
        int result = seat.getPrice();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 좌석_번호를_반환한다() {
        // given
        String expected = "A1";

        // when
        String result = seat.getSeatNumber();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
