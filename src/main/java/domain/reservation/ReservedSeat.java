package domain.reservation;

import domain.screening.Screening;
import domain.seat.Seat;

import java.time.LocalDateTime;

public record ReservedSeat(
        Screening screening,
        Seat seat,
        Boolean isBook
) {
    private static final String ERROR_ALREADY_BOOKED = "이미 예약된 좌석은 예매할 수 없습니다.";
    private static final String ERROR_NOT_BOOKED = "예약이 되지 않은 좌석입니다.";

    public ReservedSeat(Screening screening, Seat seat) {
        this(screening, seat, false);
    }

    public boolean getIsBook() {
        return isBook();
    }

    public ReservedSeat book() {
        if (isBook) {
            throw new IllegalArgumentException(ERROR_ALREADY_BOOKED);
        }
        return new ReservedSeat(screening, seat, true);
    }

    public ReservedSeat cancel() {
        if (!isBook) {
            throw new IllegalArgumentException(ERROR_NOT_BOOKED);
        }
        return new ReservedSeat(screening, seat, false);
    }

    public int getOriginalPrice() {
        return seat.getPrice();
    }

    public LocalDateTime getScreeningTime() {
        return screening.getStartTime();
    }
}