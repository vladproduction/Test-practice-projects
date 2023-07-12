package converter;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    private final static double EPS = 1e-3;

    Converter converter;

    @BeforeEach
    void setUp() {
        converter = new Converter();
    }

    @Test
    void testConvertCelsiusToFahrenheit() {
        double celsius = 10.0;
        double expected = 50.0;
        double actual = converter.convertCelsiusToFahrenheit(celsius);
//        assertEquals(expected, actual, EPS, "error conversion");
        assertThat(actual)
                .as("error conversion")
                .isCloseTo(expected, Percentage.withPercentage(0.001));
    }

    @Test
    void testCheckCelsius() {
        assertThat(converter.checkCelsius(30.0)).as("error check").isTrue();
    }

    @Test
    void testCheckCelsiusFalse() {
        assertThat(converter.checkCelsius(-300)).as("error check false").isFalse();
    }
}