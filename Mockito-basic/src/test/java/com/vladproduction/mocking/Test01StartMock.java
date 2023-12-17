package com.vladproduction.mocking;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Test01StartMock {

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
    public void calculatePrice_IfInputOk(){
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
        double expected = 4 * 2 * 20.0;
        //when
        double actual = reservationService.calculatePriceEuro(request);
        //then
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);

    }

}
