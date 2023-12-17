package com.vladproduction.services;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.utils.CurrencyConverter;

import java.time.temporal.ChronoUnit;

public class ReservationServiceImpl implements ReservationService {
    private static final double BASE_PRICE_RESERVATION_EURO = 20.0;

    private final PaymentService paymentService;
    private final TableService tableService;
    private final DaoService daoService;
    private final MailSenderService mailSenderService;

    public ReservationServiceImpl(PaymentService paymentService, TableService tableService,
                                  DaoService daoService, MailSenderService mailSenderService) {

        this.paymentService = paymentService;
        this.tableService = tableService;
        this.daoService = daoService;
        this.mailSenderService = mailSenderService;
    }

    @Override
    public int getAllAvailablePlaces() {
        return tableService.getAvailableTables()
                .stream()
                .map(table->table.getTableCapacity())
                .reduce(0, Integer::sum);
    }

    @Override
    public double calculatePriceEuro(ReservationRequest reservationRequest) {
        long baseHours = ChronoUnit.HOURS.between(reservationRequest.getTimeFrom(), reservationRequest.getTimeTo());
        return BASE_PRICE_RESERVATION_EURO * reservationRequest.getGuestCount() * baseHours; //todo
    }

    @Override
    public double calculatePriceUsd(ReservationRequest reservationRequest) {
        long baseHours = ChronoUnit.HOURS.between(reservationRequest.getTimeFrom(), reservationRequest.getTimeTo());
        return CurrencyConverter.toUsd(BASE_PRICE_RESERVATION_EURO * reservationRequest.getGuestCount() * baseHours);
    }

    @Override
    public double calculatePriceCyn(ReservationRequest reservationRequest) {
        long baseHours = ChronoUnit.HOURS.between(reservationRequest.getTimeFrom(), reservationRequest.getTimeTo());
        return CurrencyConverter.toCny(BASE_PRICE_RESERVATION_EURO * reservationRequest.getGuestCount() * baseHours);
    }

    @Override
    public String makeReservation(ReservationRequest reservationRequest) {
        String tableId = tableService.findAvailableTableId(reservationRequest);
        double priceEuro = calculatePriceEuro(reservationRequest);

        if(reservationRequest.isPrepaid()){
            paymentService.pay(reservationRequest, priceEuro);
        }

        reservationRequest.setTableId(tableId);
        String reservationId = daoService.save(reservationRequest);
        tableService.reservationTable(tableId);
        mailSenderService.sendReservationConfirm(reservationId);

        return reservationId;
    }

    @Override
    public void cancelReservation(String id) {
        ReservationRequest reservationRequest = daoService.get(id);
        tableService.cancelingReservationTable(reservationRequest.getTableId());
        daoService.delete(id);

    }
}
