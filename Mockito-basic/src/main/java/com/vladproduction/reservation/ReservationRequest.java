package com.vladproduction.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ReservationRequest {

    private final String customerId;
    private final LocalDate date;
    private final LocalTime timeFrom;
    private final LocalTime timeTo;
    private final int guestCount;
    private final boolean prepaid;
    private String tableId;

    public ReservationRequest(String customerId, LocalDate date, LocalTime timeFrom, LocalTime timeTo,
                              int guestCount, boolean prepaid) {
        this.customerId = customerId;
        this.date = date;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.guestCount = guestCount;
        this.prepaid = prepaid;
    }

    public String getCustomerId() {
        return customerId;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTimeFrom() {
        return timeFrom;
    }
    public LocalTime getTimeTo() {
        return timeTo;
    }
    public int getGuestCount() {
        return guestCount;
    }
    public boolean isPrepaid() {
        return prepaid;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ReservationRequest that = (ReservationRequest) object;
        return guestCount == that.guestCount && prepaid == that.prepaid && Objects.equals(customerId, that.customerId) && Objects.equals(date, that.date) && Objects.equals(timeFrom, that.timeFrom) && Objects.equals(timeTo, that.timeTo) && Objects.equals(tableId, that.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, date, timeFrom, timeTo, guestCount, prepaid, tableId);
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "customerId='" + customerId + '\'' +
                ", date=" + date +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", guestCount=" + guestCount +
                ", prepaid=" + prepaid +
                ", tableId='" + tableId + '\'' +
                '}';
    }
}
