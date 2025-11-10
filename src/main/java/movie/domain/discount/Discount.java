package movie.domain.discount;

import movie.domain.reservation.Invoice;

public interface Discount {
    Invoice discount(Invoice invoice);
}

