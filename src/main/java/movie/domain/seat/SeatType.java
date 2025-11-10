package movie.domain.seat;

public enum SeatType {
    S(18_000),
    A(15_000),
    B(12_000);

    private final int price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
