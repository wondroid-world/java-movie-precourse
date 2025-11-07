package domain.discount;

import domain.reservation.Invoice;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TimeDiscountTest {
    @Test
    void 오전_11시_이전이면_time_discount를_받는다() {
        // given
        TimeDiscount timeDiscount = new TimeDiscount();
        Invoice invoice = EARLY_BIRD_TIME_DISCOUNT_INVOICE;
        int expected = 13_000;

        // when
        Invoice result = timeDiscount.discount(invoice);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }

    @Test
    void 오후_8시_이후이면_time_discount를_받는다() {
        // given
        TimeDiscount timeDiscount = new TimeDiscount();
        Invoice invoice = LATE_BIRD_TIME_DISCOUNT_INVOICE;
        int expected = 13_000;

        // when
        Invoice result = timeDiscount.discount(invoice);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }

    @Test
    void 오전_11시와_오후_8시_사이면_time_discount를_못_받는다() {
        // given
        TimeDiscount timeDiscount = new TimeDiscount();
        Invoice invoice = NO_TIME_DISCOUNT_INVOICE;
        int expected = 15_000;

        // when
        Invoice result = timeDiscount.discount(invoice);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }
}
