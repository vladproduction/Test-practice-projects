package com.vladproduction.services;

import com.vladproduction.reservation.ReservationRequest;

import java.time.temporal.ChronoUnit;

public interface ReservationService {



    int getAllAvailablePlaces();

    double calculatePriceEuro(ReservationRequest reservationRequest);

    double calculatePriceUsd(ReservationRequest reservationRequest);

    double calculatePriceCyn(ReservationRequest reservationRequest);

    String makeReservation(ReservationRequest reservationRequest);

    void cancelReservation(String id);



}
