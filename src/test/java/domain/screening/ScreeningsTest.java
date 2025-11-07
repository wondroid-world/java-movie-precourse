package domain.screening;

import domain.theater.Theater;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScreeningsTest {

    @Test
    void 운영_시간_안이고_같은_날짜면_스케줄에_상영을_추가할_수_있다() {
        // given
        Theater theater = THEATER;
        LocalDate date = LocalDate.of(2025, 11, 1);
        Screenings screenings = new Screenings();

        Screening screening = FIRST_SCREENING;

        // when
        screenings.add(screening);

        // then
        assertThat(screenings.getScreenings()).hasSize(1);
        assertThat(screenings.getScreenings().get(0)).isEqualTo(screening);
    }

    @Test
    void 이미_있는_상영과_시간이_겹치면_예외를_던진다() {
        // given
        Theater theater = THEATER;
        LocalDate date = LocalDate.of(2025, 11, 1);
        Screenings screenings = new Screenings();

        Screening first = FIRST_SCREENING;
        Screening overlapped = OVERLAPPED_SCREENING;

        screenings.add(first);

        // when & then
        assertThatThrownBy(() -> screenings.add(overlapped))
                .isInstanceOf(IllegalArgumentException.class);
    }
}