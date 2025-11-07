package domain.seat;

public class Seat {
    private final SeatNumber seatNumber;
    private final SeatType seatType;

    public Seat(SeatNumber seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public Seat(char row, int column, SeatType seatType) {
        this(new SeatNumber(new Row(row), new Column(column)), seatType);
    }

    public String getSeatNumber() {
        return seatNumber.getSeatNumber();
    }

    public int getPrice() {
        return seatType.getPrice();
    }
}
