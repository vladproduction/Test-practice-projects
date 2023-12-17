package com.vladproduction.mocking;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Test02ReturnDefaultValues {

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

        System.out.println("List returned: " + tableServiceMock.getAvailableTables());
        System.out.println("Object returned: " + tableServiceMock.findAvailableTableId(null));
        System.out.println("Integer returned: " + tableServiceMock.getTableCapacity());


    }

    @Test
    public void countAvailablePlaces(){
        //given
        double expected = 0;
        //when
        double actual = reservationService.getAllAvailablePlaces();
        //then
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);

    }

}
