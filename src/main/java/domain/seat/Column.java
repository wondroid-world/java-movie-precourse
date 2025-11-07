package domain.seat;

public record Column(int value) {
    private static final int START_COLUMN = 1;
    private static final int END_COLUMN = 45;
    private static final String ERROR_SEAT_COLUMN = "열은 1 ~ 45 사이의 숫자만 올 수 있습니다.";

    public Column {
        if (value < START_COLUMN || value > END_COLUMN) {
            throw new IllegalArgumentException(ERROR_SEAT_COLUMN);
        }
    }
}
