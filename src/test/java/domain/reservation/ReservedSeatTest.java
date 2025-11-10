package domain.reservation;

import movie.domain.reservation.ReservedSeat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.MOVIE_DAY_RESERVED_SEAT;
import static org.assertj.core.api.Assertions.assertThat;

public class ReservedSeatTest {
    private ReservedSeat reservedSeat;

    @BeforeEach
    void setup() {
        reservedSeat = MOVIE_DAY_RESERVED_SEAT;
    }

    @Test
    void 좌석을_처음_잡았을때_빈_좌석이다(){
        // given, when
        Boolean result = reservedSeat.getIsBook();

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 좌석을_예약하면_true를_반환한다() {
        // given, when
        ReservedSeat newReservedSeat = reservedSeat.book();
        Boolean result = newReservedSeat.getIsBook();

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 좌석을_예약을_취소하면_false를_반환한다() {
        // given
        ReservedSeat booked = reservedSeat.book();
        ReservedSeat canceledSeat = booked.cancel();

        // when
        Boolean result = canceledSeat.getIsBook();

        // then
        assertThat(result).isFalse();
    }
}
