package converter;

import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertSame;

public class ConverterTest {
    private final static double EPS = 1e-3;

    Converter converter;

    @BeforeMethod
    public void setUp() {
        converter = new Converter();
    }

    @Test
    public void testConvertCelsiusToFahrenheit() {
        double celsius = 10.0;
        double expected = 50.0;
        double actual = converter.convertCelsiusToFahrenheit(celsius);

        assertThat(actual)
                .as("error conversion")
                .isCloseTo(expected, Percentage.withPercentage(0.001));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "error data")
    public void testConvertCelsiusToFahrenheitException() {
        converter.convertCelsiusToFahrenheit(-300);
    }

    @Test
    public void testCheckCelsius() {
        assertThat(converter.checkCelsius(30.0)).as("error check").isTrue();
    }

    @Test
    public void testCheckCelsiusFalse() {
        assertThat(converter.checkCelsius(-300)).as("error check false").isFalse();
    }

    @Test(enabled = false)
    public void checkSameTest() {
        String actual = "java" + 17;
        String expected = "ja" + "va" + 17;
        assertSame(actual, expected);
    }

    @Test(timeOut = 500)
    public void testTime() {
        IntStream.range(-273, 100_000_000)
                //.boxed()
                .forEach(t -> converter.convertCelsiusToFahrenheit(t));
    }

    @Test(dataProvider = "staticData", dataProviderClass = StaticDataProvider.class)
    public void testFromStaticDataProvider(double celsius, double expectedFahrenheit) {
        assertThat(converter.convertCelsiusToFahrenheit(celsius))
                .as("error conversion")
                .isCloseTo(expectedFahrenheit, Percentage.withPercentage(0.001));
    }

    @Test(dataProvider = "dataForConvertCelsiusToFahrenheit")
    public void testConvertCelsiusToFahrenheitParametrized(double celsius, double expectedFahrenheit) {
        assertThat(converter.convertCelsiusToFahrenheit(celsius))
                .as("error conversion")
                .isCloseTo(expectedFahrenheit, Percentage.withPercentage(0.001));
    }

    @DataProvider(name = "dataForConvertCelsiusToFahrenheit")
    public Object[][] createData() {
        return new Object[][]{
                {0, 32},
                {10, 50},
                {40, 104}
        };
    }
}