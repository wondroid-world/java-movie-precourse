package movie.domain.discount;

import movie.domain.reservation.Invoice;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeDiscount implements Discount {
    public static final int TIME_DISCOUNT_PRICE = 2000;
    public static final LocalTime EARLY_BIRD_DISCOUNT = LocalTime.of(11, 0);
    public static final LocalTime LATE_BIRD_DISCOUNT = LocalTime.of(20, 0);

    @Override
    public Invoice discount(Invoice invoice) {
        if (isTimeDiscount(invoice.getScreeningTime())) return invoice.applyAmount(TIME_DISCOUNT_PRICE);
        return invoice;
    }

    private boolean isTimeDiscount(LocalDateTime datetime) {
        LocalTime time = datetime.toLocalTime();
        return time.isBefore(EARLY_BIRD_DISCOUNT) || time.isAfter(LATE_BIRD_DISCOUNT);
    }
}
