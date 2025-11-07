package domain.reservation;

import domain.PaymentMethod;
import domain.Point;

import java.time.LocalDateTime;

public class Invoice {
    private final ReservedSeat reservedSeat;
    private final int payPrice;
    private final Point usedPoint;
    private final PaymentMethod paymentMethod;

    private Invoice(ReservedSeat reservedSeat, int payPrice, Point usedPoint, PaymentMethod paymentMethod) {
        this.reservedSeat = reservedSeat;
        this.payPrice = payPrice;
        this.usedPoint = usedPoint;
        this.paymentMethod = paymentMethod;
    }

    public Invoice(ReservedSeat reservedSeat, Point usedPoint, PaymentMethod paymentMethod) {
        this.reservedSeat = reservedSeat;
        this.payPrice = reservedSeat.getOriginalPrice();
        this.usedPoint = usedPoint;
        this.paymentMethod = paymentMethod;
    }

    public int getOriginalPrice() {
        return reservedSeat.getOriginalPrice();
    }

    public int getPayPrice() {
        return payPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getScreeningTime() {
        return reservedSeat.getScreeningTime();
    }

    public Invoice applyRate(double rate) {
        int discounted = (int) Math.round(this.payPrice * (1 - rate));
        return new Invoice(reservedSeat, discounted, usedPoint, paymentMethod);
    }

    public Invoice applyAmount(int amount) {
        int discounted = Math.max(0, this.payPrice - amount);
        return new Invoice(reservedSeat, discounted, usedPoint, paymentMethod);
    }

    public Invoice applyPoint(Point point) {
        int discounted = Math.max(0, this.payPrice - point.value());
        return new Invoice(reservedSeat, discounted, usedPoint.plus(point), paymentMethod);
    }
}
