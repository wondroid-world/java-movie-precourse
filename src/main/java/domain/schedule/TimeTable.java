package domain.schedule;

import domain.theater.Theater;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimeTable {
    private static final String ERROR_THEATER_CLOSED = "상영관의 운영 시간이 끝났습니다.";
    private static final String ERROR_DIFFERENT_DATE = "다른 날짜 상영은 이 스케줄에 넣을 수 없습니다.";
    private static final String ERROR_OVERLAPPED = "이미 존재하는 상영과 시간이 겹칩니다.";

    private final Theater theater;
    private final LocalDate date;
    private final List<Screening> screenings = new ArrayList<>();

    public TimeTable(Theater theater, LocalDate date) {
        this.theater = theater;
        this.date = date;
    }

    public void add(Screening screening) {
        if (!theater.inOperation(screening.getStartTime().toLocalTime())) {
            throw new IllegalArgumentException(ERROR_THEATER_CLOSED);
        }
        if (!screening.getStartTime().toLocalDate().equals(date)) {
            throw new IllegalArgumentException(ERROR_DIFFERENT_DATE);
        }

        for (Screening existing : screenings) {
            if (isOverlapped(existing, screening)) {
                throw new IllegalArgumentException(ERROR_OVERLAPPED);
            }
        }
        screenings.add(screening);
    }

    private boolean isOverlapped(Screening a, Screening b) {
        return a.getStartTime().isBefore(b.getEndTime())
                && b.getStartTime().isBefore(a.getEndTime());
    }

    public List<Screening> getScreenings() {
        return List.copyOf(screenings);
    }
}
