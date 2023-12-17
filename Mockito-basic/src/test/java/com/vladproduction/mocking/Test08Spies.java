package com.vladproduction.mocking;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.*;

public class Test08Spies {

    private ReservationService reservationService;
    private PaymentService paymentServiceMock;
    private TableService tableServiceMock;
    private DaoService daoServiceMock;
    private MailSenderService mailSenderServiceMock;

    @BeforeEach
    public void setup(){
        this.paymentServiceMock = mock(PaymentService.class);
        this.tableServiceMock = mock(TableService.class);
        this.daoServiceMock = spy(DaoServiceImpl.class); //mock-->spy, have to spy implemented class, not enough interface
        this.mailSenderServiceMock = mock(MailSenderService.class);

        this.reservationService = new ReservationServiceImpl(paymentServiceMock, tableServiceMock,
                daoServiceMock, mailSenderServiceMock);

    }

    @Test
    public void makeReservation_IfInputOk(){
        //given
        ReservationRequest request = new ReservationRequest("1",LocalDate.of(2023, 12, 31),
                LocalTime.of(18,00),LocalTime.of(20,00),4,true);

        //when
        String reservationId = reservationService.makeReservation(request);

        //then
        verify(daoServiceMock).save(request);
        System.out.println("reservationId = " + reservationId);
    }

    @Test
    public void cancelReservation_IfInputOk(){
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
        request.setTableId("1");
        String reservationId = "111";
        doReturn(request).when(daoServiceMock).get(reservationId);

        //when
        reservationService.cancelReservation(reservationId);

        //then
        //no exceptions
    }

}
