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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Test05ThrowingExceptions {

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
    public void throwException_IfNoTablesAvailable(){
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
        when(this.tableServiceMock.findAvailableTableId(request)).thenThrow(BusinessException.class);
        //when
        Executable executable = ()->reservationService.makeReservation(request); //??? todo
        //then
        assertThrows(BusinessException.class, executable);



    }

}
