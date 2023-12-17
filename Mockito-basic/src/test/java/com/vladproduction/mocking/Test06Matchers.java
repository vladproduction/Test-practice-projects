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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Test06Matchers {

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
    public void noCompleteReservation_IfPriceTooHigh(){
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
        //when(this.paymentServiceMock.pay(any(), anyDouble())).thenThrow(BusinessException.class);
        //or
        when(this.paymentServiceMock.pay(any(), eq(160.0))).thenThrow(BusinessException.class);
        //when
        Executable executable = ()->reservationService.makeReservation(request);
        //then
        assertThrows(BusinessException.class, executable);



    }

}
