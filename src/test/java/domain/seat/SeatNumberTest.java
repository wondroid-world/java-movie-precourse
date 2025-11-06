package domain.seat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatNumberTest {
    @Test
    void 행이_A이고_열이_1이면_좌석_번호는_A1이다() {
        // given
        Row row = new Row('A');
        Column column = new Column(1);

        // when
        SeatNumber seatNumber = new SeatNumber(row, column);

        // then
        assertThat(seatNumber.getSeatNumber()).isEqualTo("A1");
    }
}
