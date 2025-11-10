package domain.reservation;

import movie.domain.reservation.Reservation;
import movie.domain.reservation.ReservedSeat;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class ReservationTest {
    @Test
    void 겹치지_않는_상영은_예약에_추가할_수_있다() {
        // given
        Reservation reservation = new Reservation();
        ReservedSeat first = FIRST_RESERVEDSEAT;
        ReservedSeat second = SECOND_RESERVEDSEAT;

        reservation.add(first);

        // when & then
        assertThatCode(() -> reservation.add(second))
                .doesNotThrowAnyException();
    }

    @Test
    void 겹치는_상영은_예약에_추가할_수_없다() {
        // given
        Reservation reservation = new Reservation();
        ReservedSeat first = FIRST_RESERVEDSEAT;
        ReservedSeat second = OVERLAPPED_RESERVEDSEAT;

        reservation.add(first);

        // when & then
        assertThatThrownBy(() -> reservation.add(second))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
