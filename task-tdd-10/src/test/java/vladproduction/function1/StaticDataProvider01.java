package vladproduction.function1;

import org.testng.annotations.DataProvider;

public class StaticDataProvider01 {

    @DataProvider(name = "dataForFunction")
    public static Object[][] createDataForFunction() {
        return new Object[][]{
                {0.5, 1},
                {2.0, -0.240462},
                {1.0, 0.0}, //not good example, test working(!) without any logic in function
                {1.1, -0.057662},
                {0.7, 1},
                {1.4, -0.329742}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps() {
        return new Object[][]{
                {0.0, 10.0, 0.1, 101},
                {0.0, 3.0, 0.004, 751}
        };
    }

    @DataProvider(name = "dataForWriteX")
    public static Object[][] createDataForWriteX() {
        return new Object[][]{
                {175, 0.7},
                {350, 1.4},
                {750, 3.0}
        };
    }

    @DataProvider(name = "dataForWriteY")
    public static Object[][] createDataForWriteY() {
        return new Object[][]{
                {175, 1.0},
                {350, -0.329742}, //(example how to count): -0.5*(1.4^2)*ln(1.4)
                {750, 0.214242} //Math.exp(a*x)*Math.cos(b*x);--> e^(-1.5)*cos(6)-->e^(-0.5*3)cos(2*3)
        };
    }



    @DataProvider(name = "dataFindMinY")
    public static Object[][] dataFindMinY() {
        return new Object[][][]{
                {{0.2,10, 30.2,-2,300,0},{3}}

        };
    }
}
