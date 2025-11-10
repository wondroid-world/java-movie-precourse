package movie.domain.seat;

public record SeatNumber(
        Row row, Column column
) {
    public String getSeatNumber() {
        return row.value() + String.valueOf(column.value());
    }
}
