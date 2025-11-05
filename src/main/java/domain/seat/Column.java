package domain.seat;

public record Column(int value) {
    public Column {
        if (value < START_VALUE || value > END_VALUE) {
            throw new IllegalArgumentException(ERROR_SEAT_COLUMN);
        }
    }

    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    public static final String ERROR_SEAT_COLUMN = "열은 1 ~ 45 사이의 숫자만 올 수 있습니다.";
}
