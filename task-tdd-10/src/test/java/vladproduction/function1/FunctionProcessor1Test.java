package vladproduction.function1;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;


public class FunctionProcessor1Test {

    private FunctionProcessor1 fp1;
    private static final double EPS = 1e-6;

    @BeforeMethod
    public void setUp() {
        fp1 = new FunctionProcessor1();
    }

    @Test(dataProvider = "dataForFunction", dataProviderClass = StaticDataProvider01.class)
    public void testFunction(double x, double expected) {
        double actual = fp1.function(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider01.class)
    public void testSteps(double start, double finish, double step, int expectSteps) {
        int actualSteps = fp1.stepsCount(start, finish, step);
        assertThat(actualSteps).isEqualTo(expectSteps);
    }

    @Test(dataProvider = "dataForWriteX", dataProviderClass = StaticDataProvider01.class)
    public void testWriteX(int index, double expected) {
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;
        double[] x = fp1.writeX(start, finish, step);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForWriteY", dataProviderClass = StaticDataProvider01.class)
    public void testWriteY(int index, double expected) {
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;
        double[] x = fp1.writeX(start, finish, step);
        double[] y = fp1.writeY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));

    }

    @Test(dataProvider = "dataForIndexMinY", dataProviderClass = StaticDataProvider01.class)
    public void testIndexMinY(double start, double finish, double step, int expected) {
        double [] x = fp1.writeX(start, finish, step);
        double [] y = fp1.writeY(x);
        int actual = fp1.findMinY(y);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForIndexMaxY", dataProviderClass = StaticDataProvider01.class)
    public void testIndexMaxY(double start, double finish, double step, int expected) {
        double [] x = fp1.writeX(start, finish, step);
        double [] y = fp1.writeY(x);
        int actual = fp1.findMaxY(y);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForMinYByX", dataProviderClass = StaticDataProvider01.class)
    public void testFindMinYByX(double start, double finish, double step, int expected) {
        double [] x = fp1.writeX(start, finish, step);
        int actual = fp1.findMinYByX(x);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForMaxYByX", dataProviderClass = StaticDataProvider01.class)
    public void testFindMaxYByX(double start, double finish, double step, int expected) {
        double [] x = fp1.writeX(start, finish, step);
        int actual = fp1.findMaxYByX(x);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticDataProvider01.class)
    public void testSum(double start, double finish, double step, double expected) {
        double [] x = fp1.writeX(start, finish, step);
        double [] y = fp1.writeY(x);
        double actual = fp1.sum(y);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForAvg", dataProviderClass = StaticDataProvider01.class)
    public void testAvg(double start, double finish, double step, double expected) {
        double [] x = fp1.writeX(start, finish, step);
        double [] y = fp1.writeY(x);
        double actual = fp1.avg(y);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSumByX", dataProviderClass = StaticDataProvider01.class)
    public void testSumByX(double start, double finish, double step, double expected) {
        double [] x = fp1.writeX(start, finish, step);
        double actual = fp1.sumByX(x);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForAvgByX", dataProviderClass = StaticDataProvider01.class)
    public void testAvgByX(double start, double finish, double step, double expected) {
        double [] x = fp1.writeX(start, finish, step);
        double actual = fp1.avgByX(x);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }


}








