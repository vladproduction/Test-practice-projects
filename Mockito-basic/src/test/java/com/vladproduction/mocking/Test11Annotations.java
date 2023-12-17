package com.vladproduction.mocking;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Test11Annotations {
    @InjectMocks
    private ReservationServiceImpl reservationServiceImpl;
    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private TableService tableServiceMock;
    @Mock
    private DaoService daoServiceMock;
    @Mock
    private MailSenderService mailSenderServiceMock;
    @Captor
    private ArgumentCaptor<Double> doubleArgumentCaptor;


    @Test
    public void payCorrectPrice_IfInputOk() {
        //given
        ReservationRequest request = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(18, 00),
                LocalTime.of(20, 00),
                4,
                true);

        //when
        reservationServiceImpl.makeReservation(request);

        //then
        verify(paymentServiceMock, times(1)).pay(eq(request), doubleArgumentCaptor.capture());
        Double value = doubleArgumentCaptor.getValue();

        assertEquals(160.0, value);
    }

    @Test
    public void payCorrectPrices_IfInputOk() {
        //given
        ReservationRequest request1 = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(18, 00),
                LocalTime.of(20, 00),
                4,
                true);
        ReservationRequest request2 = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(20, 00),
                LocalTime.of(22, 00),
                4,
                true);
        List<Double> expectedValues = Arrays.asList(160.0, 160.0);

        //when
        reservationServiceImpl.makeReservation(request1);
        reservationServiceImpl.makeReservation(request2);

        //then
        verify(paymentServiceMock, times(2)).pay(any(), doubleArgumentCaptor.capture());
        List<Double> value = doubleArgumentCaptor.getAllValues();

        assertEquals(expectedValues, value);
    }

}
