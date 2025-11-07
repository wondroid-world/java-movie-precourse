package domain.discount;

import domain.reservation.Invoice;

public interface Discount {
    Invoice discount(Invoice invoice);
}

