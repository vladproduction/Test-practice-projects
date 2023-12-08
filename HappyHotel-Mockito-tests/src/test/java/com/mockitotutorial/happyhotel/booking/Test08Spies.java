package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class Test08Spies {

    private BookingService bookingService;

    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    public void setup() {

        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = spy(BookingDAO.class); // change mock --> to spy
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

    }

    @Test
    public void shouldMakeBooking_WhenInputOk() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                LocalDate.of(2023, 01, 05), 2, true);

        //when
        String bookingId = bookingService.makeBooking(bookingRequest);

        //then
        verify(bookingDAOMock).save(bookingRequest);
        System.out.println("bookingId = " + bookingId);

        //bookingId = null - in case mock
        //bookingId = 934b0705-6a7a-4f1a-816c-6f2815fd9a31 - in case spy

        /*mock = dummy object with no real logic
        * spy = real object with real logic that we can modify*/

    }

    @Test
    public void shouldCancelBooking_WhenInputOk() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2023, 01, 01),
                LocalDate.of(2023, 01, 05), 2, true);
        bookingRequest.setRoomId("1.3");
        String bookingId = "1";

        doReturn(bookingRequest).when(bookingDAOMock).get(bookingId);
        //when
        //bookingService.cancelBooking(bookingId); //NullPointerException: because "request" is null

        //then

        //mocks: when(mock.method()).thenReturn();
        //spies: doReturn().when(spy).method();

    }


}
