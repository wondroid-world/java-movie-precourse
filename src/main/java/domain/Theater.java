package domain;

import java.time.LocalTime;

public record Theater(LocalTime openingTime, LocalTime closingTime) {

    public boolean inOperation(LocalTime time) {
        return time.isAfter(openingTime) && time.isBefore(closingTime);
    }
}
