package domain.discount;

import domain.fixture.Fixture;
import domain.reservation.Invoice;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.CARD_INVOICE;
import static domain.fixture.Fixture.CASH_INVOICE;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentDiscountTest {
    private PaymentDiscount paymentDiscount = new PaymentDiscount();

    @Test
    void 카드로_결제하면_5퍼센트_할인이된다() {
        // given
        Invoice invoice = Fixture.CARD_INVOICE;
        int expected = (int) (CARD_INVOICE.getOriginalPrice() * (1 - 0.05));

        // when
        Invoice result = paymentDiscount.discount(invoice);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }

    @Test
    void 카드로_결제하면_2퍼센트_할인이된다() {
        // given
        Invoice invoice = Fixture.CASH_INVOICE;
        int expected = (int) (CARD_INVOICE.getOriginalPrice() * (1 - 0.02));

        // when
        Invoice result = paymentDiscount.discount(CASH_INVOICE);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }
}
