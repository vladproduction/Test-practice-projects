package vladproduction.function5;

import org.testng.annotations.DataProvider;

public class StaticDataProvider05 {

    @DataProvider(name = "dataForFunction")
    public static Object[][] createDataForFunction() {
        return new Object[][]{
                {0.2, 3.313830},
                {2.8, -2.453155},
                {0.1, 3.415614},
                {0.3, 3.148703},
                {1.1, 14.61},
                {2.5, -5.154453},
                {2.3, 13.889999}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps() {
        return new Object[][]{
                {0.0, 2.0, 0.01, 201},
                {0.2, 2.0, 0.002, 901},
                {0.2, 2.8, 0.002, 1301}
        };
    }

    @DataProvider(name = "dataForWriteX")
    public static Object[][] createDataForWriteX() {
        return new Object[][]{
                {0, 0.2},
                {50, 0.300000},
                {1050, 2.300000},
                {1300, 2.800000}
        };
    }

    @DataProvider(name = "dataForWriteY")
    public static Object[][] createDataForWriteY() {
        return new Object[][]{
                {0, 3.313830},
                {50, 3.148703},
                {1050, 13.889999},
                {1300, -2.453155}
        };
    }

    @DataProvider(name = "dataForIndexMinY")
    public static Object[][] createDataForIndexMinY() {
        return new Object[][]{
                {0.2, 2.8, 0.002, 1051},
                {0.0, 10.0, 0.001, 7854},
                {2.0, 3.0, 0.1, 4},


        };
    }


    @DataProvider(name = "dataForIndexMaxY")
    public static Object[][] createDataForIndexMaxY() {
        return new Object[][]{
                {0.2, 2.8, 0.002, 51},
                {0.0, 10.0, 0.1, 47},
                {3.0, 10.0, 0.5, 3}

        };
    }

    @DataProvider(name = "dataForMinYByX")
    public static Object[][] createDataForMinYByX() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 32},
                {0.0, 10.0, 0.25, 19},
                {0.2, 2.8, 0.002, 1051}
        };
    }

    @DataProvider(name = "dataForMaxYByX")
    public static Object[][] createDataForMaxYByX() {
        return new Object[][]{
                {1.0, 11.0, 0.2, 34},
                {0.0, 10.0, 0.25, 31},
                {0.2, 2.8, 0.002, 51}
        };
    }

    @DataProvider(name = "dataForSum")
    public static Object[][] createDataForSum() {
        return new Object[][]{
                {10.0, 100.0, 1, -2687.941558},
                {0.0, 10.0, 0.25, -24.936812},
                {0.2, 2.8, 0.002, 13594.060487}
        };
    }

    @DataProvider(name = "dataForAvg")
    public static Object[][] createDataForAvg() {
        return new Object[][]{
                {23.0, 33.0, 0.25, -11.816136},
                {0.0, 1.0, 0.25, 10.580265},
                {0.2, 2.8, 0.002, 10.448931}
        };
    }

    @DataProvider(name = "dataForSumByX")
    public static Object[][] createDataForSumByX() {
        return new Object[][]{
                {0.0, 6.0, 0.5, 66.380147},
                {10.0, 15.0, 0.5, -1520.743838},
                {0.2, 2.8, 0.002, 13594.060487}
        };
    }

    @DataProvider(name = "dataForAvgByX")
    public static Object[][] createDataForAvgByX() {
        return new Object[][]{
                {10.0, 100, 1, -29.537819},
                {10.0, 100.0, 0.5, -12.915108},
                {0.2, 2.8, 0.002, 10.448931}
        };
    }
}
