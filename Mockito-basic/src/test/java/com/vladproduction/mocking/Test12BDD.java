package com.vladproduction.mocking;

import com.vladproduction.model.Table;
import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
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
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Test12BDD {
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
    public void countAvailablePlaces_WhenOneTableAvailable() {
        //given
        given(this.tableServiceMock.getAvailableTables()).willReturn(Collections.singletonList(new Table("#1", 4)));
        int expected = 4;

        //when
        int actual = reservationServiceImpl.getAllAvailablePlaces();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void shouldInvokePayment_IfPrepaid() {
        //given
        ReservationRequest request = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(20, 00),
                LocalTime.of(22, 00),
                4,
                true);

        //when
        reservationServiceImpl.makeReservation(request);

        //then
        then(paymentServiceMock).should(times(1)).pay(request, 160.0);
        verifyNoMoreInteractions(paymentServiceMock);
    }

}
