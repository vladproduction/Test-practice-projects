package com.vladproduction.services;

import com.vladproduction.model.Table;
import com.vladproduction.reservation.ReservationRequest;

import java.util.List;

public interface TableService {

    String findAvailableTableId(ReservationRequest reservationRequest);
    List<Table> getAvailableTables();
    Integer getTableCapacity();
    void reservationTable(String tableId);
    void cancelingReservationTable(String tableId);
}
