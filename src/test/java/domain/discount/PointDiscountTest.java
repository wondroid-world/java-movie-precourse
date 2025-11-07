package domain.discount;

import domain.reservation.Invoice;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.MOVIE_DAY_INVOICE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointDiscountTest {

    @Test
    void 포인트를_차감하여_결제_금액을_차감할_수_있다() {
        // given
        PointDiscount pointDiscount = new PointDiscount(1000);
        Invoice invoice = MOVIE_DAY_INVOICE;
        int expected = 14_000;

        // when
        Invoice result = pointDiscount.discount(invoice);

        // then

        assertThat(result.getPayPrice()).isEqualTo(expected);
    }

    @Test
    void 포인트가_없으면_결제_금액을_차감할_수_없다() {
        // given
        PointDiscount pointDiscount = new PointDiscount(0);
        Invoice invoice = MOVIE_DAY_INVOICE;
        int expected = 15_000;

        // when
        Invoice result = pointDiscount.discount(invoice);

        // then

        assertThat(result.getPayPrice()).isEqualTo(expected);
    }
}
