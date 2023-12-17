package com.vladproduction.mocking;

import com.vladproduction.reservation.ReservationRequest;
import com.vladproduction.services.*;
import com.vladproduction.utils.CurrencyConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class Test14StaticMethods {
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
    public void calculatedCorrectPrice() {

        try(MockedStatic<CurrencyConverter> converterMockedStatic = mockStatic(CurrencyConverter.class)){
            //given
            ReservationRequest request = new ReservationRequest(
                    "1",
                    LocalDate.of(2023, 12, 31),
                    LocalTime.of(20, 00),
                    LocalTime.of(22, 00),
                    4,
                    false);
            double expected = 160.0;
            converterMockedStatic.when(()->CurrencyConverter.toCny(anyDouble())).thenReturn(160.0);
            //when
            double actual = reservationServiceImpl.calculatePriceCyn(request);
            //then
            assertEquals(expected, actual);
        }

    }

}
