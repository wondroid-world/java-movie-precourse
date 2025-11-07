package domain.discount;

import domain.reservation.Invoice;

import java.util.List;

public class MovieDayDiscount implements Discount {
    public static final double DISCOUNT_RATE = 0.1;
    public static final List<Integer> MOVIE_DAYS = List.of(10, 20, 30);

    @Override
    public Invoice discount(Invoice invoice) {
        int screeningDay = invoice.getScreeningTime().toLocalDate().getDayOfMonth();
        if (isMovieDay(screeningDay)) {
            return invoice.applyRate(DISCOUNT_RATE);
        }
        return invoice;
    }

    private boolean isMovieDay(int screeningDay) {
        return MOVIE_DAYS.contains(screeningDay);
    }
}