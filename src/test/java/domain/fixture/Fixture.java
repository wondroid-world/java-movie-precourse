package domain.fixture;

import movie.domain.PaymentMethod;
import movie.domain.Point;
import movie.domain.movie.Movie;
import movie.domain.reservation.Invoice;
import movie.domain.reservation.ReservedSeat;
import movie.domain.screening.Screening;
import movie.domain.seat.Seat;
import movie.domain.seat.SeatType;
import movie.domain.theater.Theater;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Fixture {
    public static final Movie MOVIE =
            new Movie(
                    1L,
                    "극장판 체인소 맨: 레제편",
                    120L,
                    LocalDate.of(2025, 11, 1),
                    LocalDate.of(2025, 11, 30)
            );

    public static final Theater THEATER = new Theater(1L, LocalTime.of(9, 0), LocalTime.of(22, 0));

    public static final Screening MOVIE_DAY_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 10, 11, 0, 0));

    public static final Screening NOT_MOVIE_DAY_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 11, 0, 0));

    public static final Seat SEAT = new Seat('A', 1, SeatType.A);

    public static final ReservedSeat MOVIE_DAY_RESERVED_SEAT = new ReservedSeat(
            MOVIE_DAY_SCREENING,
            SEAT,
            false
    );

    public static final ReservedSeat NOT_MOVIE_DAY_RESERVED_SEAT = new ReservedSeat(
            NOT_MOVIE_DAY_SCREENING,
            SEAT,
            false
    );

    public static final Invoice MOVIE_DAY_INVOICE = new Invoice(
            MOVIE_DAY_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CARD
    );

    public static final Invoice NOT_MOVIE_DAY_INVOICE = new Invoice(
            NOT_MOVIE_DAY_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CARD
    );

    public static final Invoice CASH_INVOICE = new Invoice(
            NOT_MOVIE_DAY_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CASH
    );

    public static final Invoice CARD_INVOICE = new Invoice(
            NOT_MOVIE_DAY_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CARD
    );

    public static final Screening EARLY_BIRD_TIME_DISCOUNT_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 10, 0, 0));

    public static final ReservedSeat EARLY_BIRD_TIME_DISCOUNT_RESERVED_SEAT = new ReservedSeat(
            EARLY_BIRD_TIME_DISCOUNT_SCREENING,
            SEAT,
            false
    );

    public static final Invoice EARLY_BIRD_TIME_DISCOUNT_INVOICE = new Invoice(
            EARLY_BIRD_TIME_DISCOUNT_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CARD
    );

    public static final Screening LATE_BIRD_TIME_DISCOUNT_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 21, 0, 0));

    public static final ReservedSeat LATE_BIRD_TIME_DISCOUNT_RESERVED_SEAT = new ReservedSeat(
            LATE_BIRD_TIME_DISCOUNT_SCREENING,
            SEAT,
            false
    );

    public static final Invoice LATE_BIRD_TIME_DISCOUNT_INVOICE = new Invoice(
            LATE_BIRD_TIME_DISCOUNT_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CARD
    );

    public static final Screening NO_TIME_DISCOUNT_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 15, 0, 0));

    public static final ReservedSeat NO_TIME_DISCOUNT_RESERVED_SEAT = new ReservedSeat(
            NO_TIME_DISCOUNT_SCREENING,
            SEAT,
            false
    );

    public static final Invoice NO_TIME_DISCOUNT_INVOICE = new Invoice(
            NO_TIME_DISCOUNT_RESERVED_SEAT,
            new Point(0),
            PaymentMethod.CARD
    );

    public static final Screening FIRST_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 10, 0, 0));
    public static final Screening SECOND_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 12, 0, 0));
    public static final Screening OVERLAPPED_SCREENING = new Screening(1L, MOVIE, THEATER, LocalDateTime.of(2025, 11, 1, 11, 0, 0));

    public static final ReservedSeat FIRST_RESERVEDSEAT = new ReservedSeat(FIRST_SCREENING, SEAT);
    public static final ReservedSeat SECOND_RESERVEDSEAT = new ReservedSeat(SECOND_SCREENING, SEAT);
    public static final ReservedSeat OVERLAPPED_RESERVEDSEAT = new ReservedSeat(OVERLAPPED_SCREENING, SEAT);
}
