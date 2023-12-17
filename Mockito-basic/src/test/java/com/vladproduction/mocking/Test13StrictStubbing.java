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
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Test13StrictStubbing {
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
    public void invokePayment_IfPrepaid() {
        //given
        ReservationRequest request = new ReservationRequest(
                "1",
                LocalDate.of(2023, 12, 31),
                LocalTime.of(20, 00),
                LocalTime.of(22, 00),
                4,
                false);

        //trying to mock and imagine that we forget about changed prepaid: true-->false
        //when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1"); //-->(defining behaviour)
        //when/than pattern will never invoke because prepaid is false

        //in that case to keep when/than pattern as structure of the test in given section we use this:
        lenient().when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1"); //test will pass
        //when
        reservationServiceImpl.makeReservation(request); //but here we are expected something to return;

        //then
        //no exception is thrown we are expected, but Unnecessary stubbings detected.
    }

}
