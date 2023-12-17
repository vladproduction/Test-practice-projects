package com.vladproduction.main;

import com.vladproduction.reservation.ReservationRequest;

import java.time.*;

public class DaoTesting {
    public static void main(String[] args) {
        PaymentServiceTesting.daoInit(getReservationRequest1(), getReservationRequest2(), getReservationRequest3());

    }

    private static ReservationRequest getReservationRequest1() {
        LocalDate reservationDate = LocalDate.of(2023, 11, 9);
        LocalTime reservationTimeFrom = LocalTime.of(10,00);
        LocalTime reservationTimeTo = LocalTime.of(12,00);

        ReservationRequest savedReservationRequestById = new ReservationRequest(
                "1.1",
                reservationDate,
                reservationTimeFrom,
                reservationTimeTo,
                5,
                true);
        savedReservationRequestById.setTableId("1");
        return savedReservationRequestById;
    }

    private static ReservationRequest getReservationRequest2() {
        LocalDate reservationDate = LocalDate.of(2023, 11, 9);
        LocalTime reservationTimeFrom = LocalTime.of(13,00);
        LocalTime reservationTimeTo = LocalTime.of(18,00);

        ReservationRequest savedReservationRequestById = new ReservationRequest(
                "1.2",
                reservationDate,
                reservationTimeFrom,
                reservationTimeTo,
                4,
                false);
        savedReservationRequestById.setTableId("2");
        return savedReservationRequestById;
    }

    private static ReservationRequest getReservationRequest3() {
        LocalDate reservationDate = LocalDate.of(2023, 11, 12);
        LocalTime reservationTimeFrom = LocalTime.of(18,00);
        LocalTime reservationTimeTo = LocalTime.of(21,30);

        ReservationRequest savedReservationRequestById = new ReservationRequest(
                "1.3",
                reservationDate,
                reservationTimeFrom,
                reservationTimeTo,
                5,
                true);
        savedReservationRequestById.setTableId("3");
        return savedReservationRequestById;
    }


}
