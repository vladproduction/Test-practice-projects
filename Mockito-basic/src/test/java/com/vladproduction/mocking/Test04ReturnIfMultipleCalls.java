package com.vladproduction.mocking;

import com.vladproduction.model.Table;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Test04ReturnIfMultipleCalls {

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
    public void countAvailablePlaces_IfMultipleTimesCalls(){
        //given
        when(this.tableServiceMock.getAvailableTables())
                .thenReturn(Collections.singletonList(new Table("1", 7)))
                .thenReturn(Collections.emptyList());
        double expectedFirst = 7;
        double expectedSecond = 0;
        //when
        double actualFirst = reservationService.getAllAvailablePlaces();
        double actualSecond = reservationService.getAllAvailablePlaces();
        //then
        assertEquals(expectedFirst, actualFirst);
        System.out.println(expectedFirst);
        System.out.println(actualFirst);

        assertEquals(expectedSecond, actualSecond);
        System.out.println(expectedSecond);
        System.out.println(actualSecond);

    }

}
