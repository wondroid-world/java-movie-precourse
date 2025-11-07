package domain.schedule;

import domain.theater.Theater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TimeTableTest {

    @Test
    void 운영_시간_안이고_같은_날짜면_스케줄에_상영을_추가할_수_있다() {
        // given
        Theater theater = THEATER;
        LocalDate date = LocalDate.of(2025, 11, 1);
        TimeTable timeTable = new TimeTable(theater, date);

        Screening screening = FIRST_SCREENING;

        // when
        timeTable.add(screening);

        // then
        assertThat(timeTable.getScreenings()).hasSize(1);
        assertThat(timeTable.getScreenings().get(0)).isEqualTo(screening);
    }

    @Test
    void 상영관_운영시간이_아니면_예외를_던진다() {
        // given
        Theater theater = THEATER;
        LocalDate date = LocalDate.of(2025, 11, 10);
        TimeTable timeTable = new TimeTable(theater, date);

        Screening screening = FIRST_SCREENING;

        // when & then
        assertThatThrownBy(() -> timeTable.add(screening))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 타임테이블의_날짜와_다른_상영을_넣으면_예외를_던진다() {
        // given
        Theater theater = THEATER;
        LocalDate date = LocalDate.of(2025, 11, 10);
        TimeTable timeTable = new TimeTable(theater, date);

        // 상영은 11/11
        Screening screening = FIRST_SCREENING;

        // when & then
        assertThatThrownBy(() -> timeTable.add(screening))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이미_있는_상영과_시간이_겹치면_예외를_던진다() {
        // given
        Theater theater = THEATER;
        LocalDate date = LocalDate.of(2025, 11, 1);
        TimeTable timeTable = new TimeTable(theater, date);

        Screening first = FIRST_SCREENING;
        Screening overlapped = OVERLAPPED_SCREENING;

        timeTable.add(first);

        // when & then
        assertThatThrownBy(() -> timeTable.add(overlapped))
                .isInstanceOf(IllegalArgumentException.class);
    }
}