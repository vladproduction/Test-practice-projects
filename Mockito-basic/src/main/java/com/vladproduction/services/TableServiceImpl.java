package com.vladproduction.services;

import com.vladproduction.exception.BusinessException;
import com.vladproduction.model.Table;
import com.vladproduction.reservation.ReservationRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TableServiceImpl implements TableService {

    private final Map<Table, Boolean> tableAvailability;
    {tableAvailability = new HashMap<>();
        tableAvailability.put(new Table("1", 4), true);
        tableAvailability.put(new Table("2", 6), true);
        tableAvailability.put(new Table("3", 8), true);
        tableAvailability.put(new Table("4", 9), true);
        tableAvailability.put(new Table("5", 15), true);
    }

    @Override
    public String findAvailableTableId(ReservationRequest reservationRequest) {
        return tableAvailability.entrySet().stream()
                .filter(entry -> entry.getValue()).map(entry -> entry.getKey())
                .filter(table -> table.getTableCapacity() == reservationRequest.getGuestCount())
                .findFirst()
                .map(table -> table.getId())
                .orElseThrow(BusinessException::new);
    }

    @Override
    public final List<Table> getAvailableTables() { //change for test 16 set as final
        return tableAvailability.entrySet().stream()
                .filter(entry -> entry.getValue())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTableCapacity() {
        return tableAvailability.size();
    }

    @Override
    public void reservationTable(String tableId) {
        Table table = tableAvailability.entrySet().stream()
                .filter(entry -> entry.getKey().getId().equals(tableId) && entry.getValue())
                .findFirst()
                .map(entry -> entry.getKey())
                .orElseThrow(BusinessException::new);
        tableAvailability.put(table, true);

    }

    @Override
    public void cancelingReservationTable(String tableId) {
        Table table = tableAvailability.entrySet().stream()
                .filter(entry -> entry.getKey().getId().equals(tableId) && !entry.getValue()) //??? todo
                .findFirst()
                .map(entry -> entry.getKey())
                .orElseThrow(BusinessException::new);
        tableAvailability.put(table, false); //todo
    }
}
