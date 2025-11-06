package domain.theater;

import java.time.LocalTime;

public record Theater(
        long id,
        OperatingHour operatingHour) {

    public Theater(long id, LocalTime openingTime, LocalTime closingTime) {
        this(id, new OperatingHour(openingTime, closingTime));
    }

    public boolean inOperation(LocalTime time) {
        return operatingHour.inOperation(time);
    }
}

