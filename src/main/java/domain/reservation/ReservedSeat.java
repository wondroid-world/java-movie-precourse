package domain.reservation;

import domain.schedule.Screening;
import domain.seat.Seat;

import java.time.LocalDateTime;

public record ReservedSeat(
        Screening screening,
        Seat seat,
        Boolean isBook
) {
    public ReservedSeat(Screening screening, Seat seat) {
        this(screening, seat, false);
    }

    public boolean getIsBook() {
        return isBook();
    }

    public ReservedSeat book() {
        return new ReservedSeat(screening, seat, true);
    }

    public ReservedSeat cancel() {
        return new ReservedSeat(screening, seat, false);
    }

    public int getOriginalPrice() {
        return seat.getPrice();
    }

    public LocalDateTime getScreeningTime() {
        return screening.getStartTime();
    }
}