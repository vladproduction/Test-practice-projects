package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Test10ArgumentCaptors {

    private BookingService bookingService;

    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;
    private ArgumentCaptor<Double> doubleArgumentCaptor;

    //private ArgumentCaptor<BookingRequest> bookingRequestArgumentCaptor; //we can have any type generic

    @BeforeEach
    public void setup() {

        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

        this.doubleArgumentCaptor = ArgumentCaptor.forClass(Double.class);
    }

    @Test
    public void shouldPayCorrectPrice_WhenInputOk() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                LocalDate.of(2023, 01, 05), 2, true);

        //when
        bookingService.makeBooking(bookingRequest);

        //then
        verify(paymentServiceMock, times(1)).pay(eq(bookingRequest), doubleArgumentCaptor.capture());
        double capturedArgument = doubleArgumentCaptor.getValue();
        System.out.println("capturedArgument = " + capturedArgument);  //capturedArgument = 400.0

        assertEquals(400.0, capturedArgument);

    }

    @Test
    public void shouldPayCorrectPrices_WhenMultipleCalls() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                LocalDate.of(2023, 01, 05), 2, true);
        BookingRequest bookingRequest2 = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                LocalDate.of(2023, 01, 02), 2, true);
        List<Double> expectedValues = Arrays.asList(400.0, 100.0);
        //when
        bookingService.makeBooking(bookingRequest);
        bookingService.makeBooking(bookingRequest2);

        //then
        verify(paymentServiceMock, times(2)).pay(any(), doubleArgumentCaptor.capture());
        List<Double> captorAllValues = doubleArgumentCaptor.getAllValues();
        System.out.println("captorAllValues = " + captorAllValues);

        assertEquals(expectedValues, captorAllValues);

    }


}
