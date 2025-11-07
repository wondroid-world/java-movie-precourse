package domain.seat;

public record Seat(
        SeatNumber seatNumber,
        SeatType seatType
) {
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
