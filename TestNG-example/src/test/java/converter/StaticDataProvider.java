package converter;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "staticData")
    public static Object[][] createData() {
        return new Object[][]{
                {0, 32},
                {10, 50},
                {40, 104}
        };
    }
}
