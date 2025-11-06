package domain.seat;

public class Seat {
    private final SeatNumber seatNumber;
    private final SeatType seatType;
    private Boolean isBook;

    public Seat(SeatNumber seatNumber, SeatType seatType, Boolean isBook) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isBook = isBook;
    }

    public Seat(SeatNumber seatNumber, SeatType seatType) {
        this(seatNumber, seatType, false);
    }

    public Seat(char row, int column, SeatType seatType) {
        this(new SeatNumber(new Row(row), new Column(column)), seatType, false);
    }

    public String getSeatNumber() {
        return seatNumber.getSeatNumber();
    }

    public Boolean getBook() {
        return isBook;
    }

    public void book() {
        isBook = true;
    }

    public void cancel() {
        isBook = false;
    }

    public int getPrice() {
        return seatType.getPrice();
    }
}
