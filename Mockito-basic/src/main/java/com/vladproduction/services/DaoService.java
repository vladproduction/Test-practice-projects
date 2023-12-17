package com.vladproduction.services;

import com.vladproduction.reservation.ReservationRequest;

public interface DaoService {

    String save(ReservationRequest reservationRequest);
    ReservationRequest get(String id);
    void delete(String reservationId);
}
