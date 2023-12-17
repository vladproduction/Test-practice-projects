package com.vladproduction.mocking;

import com.vladproduction.model.Table;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Test03ReturnCustomValues {

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
    public void countAvailablePlaces_IfOneTableAvailable(){
        //given
        when(this.tableServiceMock.getAvailableTables())
                .thenReturn(Collections.singletonList(new Table("1", 7)));
        double expected = 7;
        //when
        double actual = reservationService.getAllAvailablePlaces();
        //then
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);

    }

    @Test
    public void countAvailablePlaces_IfSomeTablesAvailable(){
        //given
        List<Table> tablesAvailable = Arrays.asList(new Table("1", 5), new Table("2", 5));
        when(this.tableServiceMock.getAvailableTables()).thenReturn(tablesAvailable);
        double expected = 10;
        //when
        double actual = reservationService.getAllAvailablePlaces();
        //then
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);

    }

}
