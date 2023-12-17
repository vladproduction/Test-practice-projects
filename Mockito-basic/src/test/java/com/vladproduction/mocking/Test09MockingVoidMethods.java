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

public class Test09MockingVoidMethods {

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
    public void throwingException_IfMailNotReady(){
        //given
        ReservationRequest request = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(18,00),
                LocalTime.of(20,00),
                4,
                false);
        doThrow(new BusinessException()).when(mailSenderServiceMock).sendReservationConfirm(any());

        //when
        Executable executable = ()->reservationService.makeReservation(request);

        //then
        assertThrows(BusinessException.class, executable);

    }

    @Test
    public void notThrowingException_IfMailNotReady(){
        //given
        ReservationRequest request = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(18,00),
                LocalTime.of(20,00),
                4,
                false);
        doNothing().when(mailSenderServiceMock).sendReservationConfirm(any());

        //when
        reservationService.makeReservation(request);

        //then
        //no exception throw

    }

}
