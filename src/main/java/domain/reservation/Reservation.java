package domain.reservation;

import domain.schedule.Screening;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private final String ERROR_OVERLAPPED_SCREENING = "시간이 겹치는 상영은 함께 예매할 수 없습니다.";
    private final List<Screening> screenings = new ArrayList<>();

    public void add(Screening screening) {
        for (Screening s : screenings) {
            if (isOverlapped(s, screening)) {
                throw new IllegalArgumentException(ERROR_OVERLAPPED_SCREENING);
            }
        }
        screenings.add(screening);
    }

    private boolean isOverlapped(Screening a, Screening b) {
        return a.getStartTime().isBefore(b.getEndTime())
                && b.getStartTime().isBefore(a.getEndTime());
    }
}
