package domain.discount;

import domain.fixture.Fixture;
import domain.reservation.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.fixture.Fixture.NOT_MOVIE_DAY_INVOICE;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyDayDiscountTest {
    private MovieDayDiscount movieDay;

    @BeforeEach
    void setup() {
        movieDay = new MovieDayDiscount();
    }

    @Test
    void 무비데이이면_10퍼센트_할인된다() {
        // given
        Invoice invoice = Fixture.MOVIE_DAY_INVOICE;
        int expected = 13_500;
        // when
        Invoice result = movieDay.discount(invoice);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }

    @Test
    void 무비데이가_아니면_할인되지_않는다() {
        // given
        Invoice invoice = NOT_MOVIE_DAY_INVOICE;
        int expected = NOT_MOVIE_DAY_INVOICE.getPayPrice();

        // when
        Invoice result = movieDay.discount(invoice);

        // then
        assertThat(result.getPayPrice()).isEqualTo(expected);
    }
}
