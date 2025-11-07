package domain;

public record Point(int value) {
    public static final String ERROR_POINT_NO_NEGATIVE = "포인트는 마이너스 값이 올 수 없습니다.";

    public Point {
        if (value < 0) throw new IllegalArgumentException(ERROR_POINT_NO_NEGATIVE);
    }

    public Point plus(Point point) {
        return new Point(this.value + point.value);
    }

    public Point minus(Point point) {
        return new Point(this.value - point.value);
    }
}
