package com.vladproduction.services;

public class MailSenderServiceImpl implements MailSenderService {
    @Override
    public void sendReservationConfirm(String reservationId) {
        System.out.println("Reservation Confirmed. reservationId = " + reservationId);

        //throw new UnsupportedOperationException("Not implemented yet.");

    }
}
