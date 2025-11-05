package domain.seat;

public record Row(char value) {
    public Row {
        if (value < 'A' || value > 'P') {
            throw new IllegalArgumentException(ERROR_SEAT_ROW);
        }
    }

    public static final String ERROR_SEAT_ROW = "행은 A ~ P 사이의 알파벳 대문자만 올 수 있습니다.";
}
