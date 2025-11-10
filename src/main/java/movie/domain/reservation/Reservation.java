package movie.domain.reservation;

import movie.domain.screening.Screening;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static final String ERROR_OVERLAPPED_SCREENING = "시간이 겹치는 상영은 함께 예매할 수 없습니다.";

    private final List<ReservedSeat> reservedSeats = new ArrayList<>();

    public void add(ReservedSeat reservedSeat) {
        for (ReservedSeat s : reservedSeats) {
            if (isOverlapped(s.screening(), reservedSeat.screening())) {
                throw new IllegalArgumentException(ERROR_OVERLAPPED_SCREENING);
            }
        }
        reservedSeats.add(reservedSeat);
    }

    private boolean isOverlapped(Screening a, Screening b) {
        return a.getStartTime().isBefore(b.getEndTime())
                && b.getStartTime().isBefore(a.getEndTime());
    }
}
