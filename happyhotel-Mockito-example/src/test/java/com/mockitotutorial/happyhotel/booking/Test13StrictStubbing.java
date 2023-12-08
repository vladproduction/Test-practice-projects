package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class Test13StrictStubbing {
    @InjectMocks
    private BookingService bookingService;
    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private RoomService roomServiceMock;
    @Mock
    //@Spy
    private BookingDAO bookingDAOMock;
    @Mock
    private MailSender mailSenderMock;
    @Captor
    private ArgumentCaptor<Double> doubleArgumentCaptor;


    @Test
    public void shouldInvokePayment_WhenPrepaid() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                LocalDate.of(2023, 01, 05), 2, false);
        //trying to mock and imagine that we forget about changed prepaid: true-->false
        //when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1"); //-->(defining behaviour)
        //when/than pattern will never invoke because prepaid is false

        //in that case to keep when/than pattern as structure of the test in given section we use this:
        lenient().when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1"); //test will pass
        //when
        bookingService.makeBooking(bookingRequest); //but here we are expected something to return;

        //then
        //no exception is thrown we are expected, but Unnecessary stubbings detected.

    }

}
