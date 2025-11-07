package domain.discount;

import domain.Point;
import domain.reservation.Invoice;

public class PointDiscount implements Discount {
    private final Point pointToUse;

    public PointDiscount(Point pointToUse) {
        this.pointToUse = pointToUse;
    }

    public PointDiscount(int value) {
        this(new Point(value));
    }

    @Override
    public Invoice discount(Invoice invoice) {
        if (pointToUse.value() <= 0) return invoice;
        return invoice.applyPoint(pointToUse);
    }
}
