package com.vladproduction.services;

import com.vladproduction.reservation.ReservationRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DaoServiceImpl implements DaoService {

    private final Map<String, ReservationRequest> reservations = new HashMap<>();

    @Override
    public String save(ReservationRequest reservationRequest) {
        String id = UUID.randomUUID().toString();
        reservations.put(id, reservationRequest);
        return id;
    }

    @Override
    public ReservationRequest get(String id) {

        return reservations.get(id);
    }

    @Override
    public void delete(String reservationId) {

        reservations.remove(reservationId);
        System.out.println("Reservation by Id: " + reservationId + " was successfully deleted.");

    }
}
