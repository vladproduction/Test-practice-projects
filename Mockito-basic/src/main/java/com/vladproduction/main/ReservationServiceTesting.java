package com.vladproduction.main;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationServiceTesting {
    public static void main(String[] args) {
        daoInit(getReservationRequest1(), getReservationRequest2(), getReservationRequest3());

        System.out.println();
        System.out.println("\tpaymentService.pay action:");
        PaymentService paymentService = new PaymentServiceImpl();
        paymentService.pay(getReservationRequest1(), 100);
        //paymentService.pay(getReservationRequest2(), 10); //UnsupportedOperationException: Reservation is not supported

        System.out.println("\treservationService action:");
        System.out.println();
        TableService tableService = new TableServiceImpl();
        DaoService daoService = new DaoServiceImpl();
        MailSenderService mailSenderService = new MailSenderServiceImpl();
        ReservationService reservationService = new ReservationServiceImpl(paymentService, tableService,
                daoService, mailSenderService);
        System.out.println("reservationService.getAllAvailablePlaces()");
        int allAvailablePlaces = reservationService.getAllAvailablePlaces();
        System.out.println("allAvailablePlaces = " + allAvailablePlaces);

        System.out.println();
        System.out.println("reservationService.calculatePriceEuro:");
        double priceEuro = reservationService.calculatePriceEuro(getReservationRequest1());
        System.out.println("priceEuro_request1 = " + priceEuro);
        System.out.println();
        System.out.println("reservationService.calculatePriceUsd:");
        double priceUsd = reservationService.calculatePriceUsd(getReservationRequest2());
        System.out.println("priceUsd_request2 = " + priceUsd);

        System.out.println();
        System.out.println("reservationService.calculatePriceCyn:");
        double priceCyn = reservationService.calculatePriceCyn(getReservationRequest3());
        System.out.println("priceCyn_request3 = " + priceCyn);

        System.out.println();
        System.out.println("reservationService.makeReservation:");
        String reservation1 = reservationService.makeReservation(getReservationRequest1());
        System.out.println("reservation1 = " + reservation1);
        String reservation2 = reservationService.makeReservation(getReservationRequest2());
        System.out.println("reservation2 = " + reservation2);
        String reservation3 = reservationService.makeReservation(getReservationRequest3());
        System.out.println("reservation3 = " + reservation3);

    }

    static void daoInit(ReservationRequest reservationRequest12,
                        ReservationRequest reservationRequest22,
                        ReservationRequest reservationRequest32) {
        DaoService daoService = new DaoServiceImpl();

        System.out.println("----------first reservation---table#1--------------");
        ReservationRequest savedReservationRequestById1 = reservationRequest12;
        String savedReservationRequestId1 = daoService.save(savedReservationRequestById1);
        ReservationRequest reservationRequest1 = daoService.get(savedReservationRequestId1);
        System.out.println("table#1 = " + reservationRequest1);

        System.out.println("----------second reservation---table#2------------");
        ReservationRequest savedReservationRequestById2 = reservationRequest22;
        String savedReservationRequestId2 = daoService.save(savedReservationRequestById2);
        ReservationRequest reservationRequest2 = daoService.get(savedReservationRequestId2);
        System.out.println("table#2 = " + reservationRequest2);

        System.out.println("----------third reservation---table#3------------");
        ReservationRequest savedReservationRequestById3 = reservationRequest32;
        String savedReservationRequestId3 = daoService.save(savedReservationRequestById3);
        ReservationRequest reservationRequest3 = daoService.get(savedReservationRequestId3);
        System.out.println("table#3 = " + reservationRequest3);

        System.out.println("\tdaoService.delete action:");
        daoService.delete(savedReservationRequestId3);
        System.out.println("table#3 = " + daoService.get(savedReservationRequestId3));
    }

    private static ReservationRequest getReservationRequest1() {
        LocalDate reservationDate = LocalDate.of(2023, 12, 10);
        LocalTime reservationTimeFrom = LocalTime.of(10,00);
        LocalTime reservationTimeTo = LocalTime.of(12,00);

        ReservationRequest savedReservationRequestById = new ReservationRequest(
                "1.1",
                reservationDate,
                reservationTimeFrom,
                reservationTimeTo,
                4,
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
                6,
                false);
        savedReservationRequestById.setTableId("2");
        return savedReservationRequestById;
    }

    private static ReservationRequest getReservationRequest3() {
        LocalDate reservationDate = LocalDate.of(2023, 11, 12);
        LocalTime reservationTimeFrom = LocalTime.of(18,00);
        LocalTime reservationTimeTo = LocalTime.of(21,00);

        ReservationRequest savedReservationRequestById = new ReservationRequest(
                "1.3",
                reservationDate,
                reservationTimeFrom,
                reservationTimeTo,
                15,
                true);
        savedReservationRequestById.setTableId("3");
        return savedReservationRequestById;
    }

}
