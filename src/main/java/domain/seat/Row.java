package domain.seat;

public record Row(char value) {
    public Row {
        if (value < START_ROW || value > END_ROW) {
            throw new IllegalArgumentException(ERROR_SEAT_ROW);
        }
    }

    private static final char START_ROW = 'A';
    private static final char END_ROW = 'P';
    public static final String ERROR_SEAT_ROW = "행은 A ~ P 사이의 알파벳 대문자만 올 수 있습니다.";
}
