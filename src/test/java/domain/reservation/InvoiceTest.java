package domain.reservation;

import domain.Point;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;

class InvoiceTest {

    @Test
    void 생성하면_좌석_원가로_payPrice가_초기화된다() {
        // given, when
        Invoice invoice = MOVIE_DAY_INVOICE;

        // then
        assertThat(invoice.getPayPrice()).isEqualTo(15_000);
        assertThat(invoice.getOriginalPrice()).isEqualTo(15_000);
    }

    @Test
    void 비율할인을_적용하면_금액이_줄어든_새로운_Invoice를_반환한다() {
        // given
        Invoice invoice = CARD_INVOICE;

        // when
        Invoice discounted = invoice.applyRate(0.10);

        // then
        assertThat(discounted.getPayPrice()).isEqualTo(13_500);
        assertThat(invoice.getPayPrice()).isEqualTo(15_000);
    }

    @Test
    void 정액할인을_적용하면_해당금액만큼_차감된_Invoice를_반환한다() {
        // given
        Invoice invoice = EARLY_BIRD_TIME_DISCOUNT_INVOICE;

        // when
        Invoice discounted = invoice.applyAmount(2_000);

        // then
        assertThat(discounted.getPayPrice()).isEqualTo(13_000);
    }

    @Test
    void 포인트를_적용하면_포인트만큼_차감되고_포인트가_누적된_Invoice를_반환한다() {
        // given
        Invoice invoice = NO_TIME_DISCOUNT_INVOICE;

        // when
        Invoice afterPoint = invoice.applyPoint(new Point(3_000));

        // then
        assertThat(afterPoint.getPayPrice()).isEqualTo(12_000);
        assertThat(invoice.getPayPrice()).isEqualTo(15_000);
    }
}