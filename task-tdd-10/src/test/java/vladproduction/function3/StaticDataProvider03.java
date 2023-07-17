package vladproduction.function3;

import org.testng.annotations.DataProvider;

public class StaticDataProvider03 {

    @DataProvider(name = "dataForFunction")
    public static Object[][] createDataForFunction() {
        return new Object[][]{
                {1.1, 6.937000},
                {1.4, 8.872},
                {1.5, 1.248075},
                {1.1, 6.937000},
                {0.0, 4.0},
                {2.0, 0.939148}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps() {
        return new Object[][]{
                {0.0, 10.0, 0.1, 101},
                {0.0, 2.0, 0.002, 1001}
        };
    }

    @DataProvider(name = "dataForWriteX")
    public static Object[][] createDataForWriteX() {
        return new Object[][]{
                {0, 0.0},
                {700, 1.4},
                {1000, 2.0}
        };
    }

    @DataProvider(name = "dataForWriteY")
    public static Object[][] createDataForWriteY() {
        return new Object[][]{
                {0, 4.0},
                {700, 8.872000},
                {1000, 0.939148}
        };
    }

    @DataProvider(name = "dataForIndexMinY")
    public static Object[][] createDataForIndexMinY() {
        return new Object[][]{
                {0.0, 2.0, 0.002, 1000},
                {0.0, 10.0, 0.01, 1000},
                {1.0, 3.0, 0.1, 20},


        };
    }


    @DataProvider(name = "dataForIndexMaxY")
    public static Object[][] createDataForIndexMaxY() {
        return new Object[][]{
                {0.0, 2.0, 0.002, 700},
                {2.0, 10.0, 0.1, 0},
                {3.0, 11.5, 0.25, 0}

        };
    }

    @DataProvider(name = "dataForMinYByX")
    public static Object[][] createDataForMinYByX() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 34},
                {0.0, 10.0, 0.25, 40},
                {0.0, 2.0, 0.002, 1000}
        };
    }

    @DataProvider(name = "dataForMaxYByX")
    public static Object[][] createDataForMaxYByX() {
        return new Object[][]{
                {1.0, 11.0, 0.2, 2},
                {0.0, 10.0, 0.25, 5},
                {0.0, 2.0, 0.002, 700}
        };
    }

    @DataProvider(name = "dataForSum")
    public static Object[][] createDataForSum() {
        return new Object[][]{
                {10.0, 100.0, 1, -20.925416},
                {0.0, 10.0, 0.25, 42.361105},
                {0.0, 2.0, 0.002, 4229.335961}
        };
    }

    @DataProvider(name = "dataForAvg")
    public static Object[][] createDataForAvg() {
        return new Object[][]{
                {3.0, 11.5, 0.25, 0.126981},
                {0.0, 10.0, 0.25, 1.033197},
                {0.0, 2.0, 0.002, 4.225110}
        };
    }

    @DataProvider(name = "dataForSumByX")
    public static Object[][] createDataForSumByX() {
        return new Object[][]{
                {4.0, 6.0, 0.5, 1.227787},
                {0.0, 10.0, 0.25, 42.361105},
                {0.0, 2.0, 0.002, 4229.335961}
        };
    }

    @DataProvider(name = "dataForAvgByX")
    public static Object[][] createDataForAvgByX() {
        return new Object[][]{
                {10.0, 100, 1, -0.229949},
                {0.0, 5.0, 0.5, 1.795539},
                {0.0, 2.0, 0.002, 4.225110}
        };
    }
}
