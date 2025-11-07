package domain.discount;

import domain.PaymentMethod;
import domain.reservation.Invoice;

public class PaymentDiscount implements Discount{
    @Override
    public Invoice discount(Invoice invoice) {
        double discountRate = switch (invoice.getPaymentMethod()) {
            case PaymentMethod.CARD -> 0.05;
            case PaymentMethod.CASH -> 0.02;
        };
        return invoice.applyRate(discountRate);
    }
}

