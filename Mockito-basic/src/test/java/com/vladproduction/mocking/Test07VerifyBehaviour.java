package com.vladproduction.mocking;

import com.vladproduction.exception.BusinessException;
import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class Test07VerifyBehaviour {

    private ReservationService reservationService;
    private PaymentService paymentServiceMock;
    private TableService tableServiceMock;
    private DaoService daoServiceMock;
    private MailSenderService mailSenderServiceMock;

    @BeforeEach
    public void setup(){
        this.paymentServiceMock = mock(PaymentService.class);
        this.tableServiceMock = mock(TableService.class);
        this.daoServiceMock = mock(DaoService.class);
        this.mailSenderServiceMock = mock(MailSenderService.class);

        this.reservationService = new ReservationServiceImpl(paymentServiceMock, tableServiceMock,
                daoServiceMock, mailSenderServiceMock);

    }

    @Test
    public void invokePayment_IfPrepaid(){
        //given
        LocalDate date = LocalDate.of(2023, 12, 31);
        LocalTime timeFrom = LocalTime.of(18,00);
        LocalTime timeTo = LocalTime.of(20,00);
        ReservationRequest request = new ReservationRequest(
                "1",
                date,
                timeFrom,
                timeTo,
                4,
                true);

        //when
        reservationService.makeReservation(request);

        //then
        verify(paymentServiceMock, times(1)).pay(request, 160.0);
        verifyNoMoreInteractions(paymentServiceMock); //??? todo
    }

    @Test
    public void notInvokePayment_IfNotPrepaid(){
        //given
        LocalDate date = LocalDate.of(2023, 12, 31);
        LocalTime timeFrom = LocalTime.of(18,00);
        LocalTime timeTo = LocalTime.of(20,00);
        ReservationRequest request = new ReservationRequest(
                "1",
                date,
                timeFrom,
                timeTo,
                4,
                false);

        //when
        reservationService.makeReservation(request);

        //then
        verify(paymentServiceMock, never()).pay(any(), anyDouble());
    }

}
