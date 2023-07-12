package converter;

public class Converter {

    private final static double ABSOLUTE_ZERO = -273.15;

    public double convertCelsiusToFahrenheit(double celsius) {
        if (celsius < ABSOLUTE_ZERO) {
            throw new IllegalArgumentException("error data");
        }
        return (celsius * 9 / 5) + 32;
    }

    public boolean checkCelsius(double celsius) {
        return celsius >= ABSOLUTE_ZERO;
    }
}
