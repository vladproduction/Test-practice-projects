package com.vladproduction.services;

import com.vladproduction.reservation.ReservationRequest;

public interface PaymentService {

    String pay(ReservationRequest reservationRequest, double price);
}
