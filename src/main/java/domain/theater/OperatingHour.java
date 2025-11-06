package domain.theater;

import java.time.LocalTime;

public record OperatingHour(
        LocalTime openingTime, LocalTime closingTime
) {
    public boolean inOperation(LocalTime time) {
        return time.isAfter(openingTime) && time.isBefore(closingTime);
    }
}