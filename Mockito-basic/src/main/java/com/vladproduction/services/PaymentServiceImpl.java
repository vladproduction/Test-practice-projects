package com.vladproduction.services;

import com.vladproduction.reservation.ReservationRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentServiceImpl implements PaymentService {

    private final Map<String, Double> payments = new HashMap<>();
    @Override
    public String pay(ReservationRequest reservationRequest, double price) {
        if(price < 40.0 && reservationRequest.getGuestCount() > 2){
            throw new UnsupportedOperationException("Reservation is not supported");
        }
        String id = UUID.randomUUID().toString();
        payments.put(id, price);
        return id;
    }
    //reservation available from at least: 1 table and 2 persons for 1 hour //todo
}
