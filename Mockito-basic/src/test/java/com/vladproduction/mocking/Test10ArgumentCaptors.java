package com.vladproduction.mocking;

import com.vladproduction.exception.BusinessException;
import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class Test10ArgumentCaptors {

    private ReservationService reservationService;
    private PaymentService paymentServiceMock;
    private TableService tableServiceMock;
    private DaoService daoServiceMock;
    private MailSenderService mailSenderServiceMock;
    private ArgumentCaptor<Double> doubleArgumentCaptor;

    @BeforeEach
    public void setup(){
        this.paymentServiceMock = mock(PaymentService.class);
        this.tableServiceMock = mock(TableService.class);
        this.daoServiceMock = mock(DaoService.class);
        this.mailSenderServiceMock = mock(MailSenderService.class);

        this.reservationService = new ReservationServiceImpl(paymentServiceMock, tableServiceMock,
                daoServiceMock, mailSenderServiceMock);

        this.doubleArgumentCaptor = ArgumentCaptor.forClass(Double.class);

    }

    @Test
    public void payCorrectPrice_IfInputOk(){
        //given
        ReservationRequest request = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(18,00),
                LocalTime.of(20,00),
                4,
                true);

        //when
        reservationService.makeReservation(request);

        //then
        verify(paymentServiceMock, times(1)).pay(eq(request), doubleArgumentCaptor.capture());
        Double value = doubleArgumentCaptor.getValue();

        assertEquals(160.0, value);
    }

    @Test
    public void payCorrectPrices_IfInputOk(){
        //given
        ReservationRequest request1 = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(18,00),
                LocalTime.of(20,00),
                4,
                true);
        ReservationRequest request2 = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(20,00),
                LocalTime.of(22,00),
                4,
                true);
        List<Double> expectedValues = Arrays.asList(160.0, 160.0);

        //when
        reservationService.makeReservation(request1);
        reservationService.makeReservation(request2);

        //then
        verify(paymentServiceMock, times(2)).pay(any(), doubleArgumentCaptor.capture());
        List<Double> value = doubleArgumentCaptor.getAllValues();

        assertEquals(expectedValues, value);
    }

}
