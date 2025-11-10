package movie.domain;

import movie.domain.discount.Discount;
import movie.domain.reservation.Invoice;

import java.util.List;

public class PriceCalculator {
    private final List<Discount> discounts;

    public PriceCalculator(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Invoice applyAllDiscount(Invoice invoice) {
        Invoice discountedInvoice = invoice;
        for (Discount discount : discounts) {
            discountedInvoice = discount.discount(discountedInvoice);
        }
        return discountedInvoice;
    }
}
