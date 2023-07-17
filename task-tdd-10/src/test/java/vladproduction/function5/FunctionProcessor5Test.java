package vladproduction.function5;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vladproduction.function3.FunctionProcessor3;
import vladproduction.function3.StaticDataProvider03;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionProcessor5Test {



    private FunctionProcessor5 fp5;

    private static final double EPS = 1e-6;

    @BeforeMethod
    public void setUp() {
        fp5 = new FunctionProcessor5();
    }

    @Test(dataProvider = "dataForFunction", dataProviderClass = StaticDataProvider05.class)
    public void testFunction(double x, double expected) {
        double actual = fp5.function(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider05.class)
    public void testSteps(double start, double finish, double step, int expectSteps) {
        int actualSteps = fp5.stepsCount(start, finish, step);
        assertThat(actualSteps).isEqualTo(expectSteps);
    }

    @Test(dataProvider = "dataForWriteX", dataProviderClass = StaticDataProvider05.class)
    public void testWriteX(int index, double expected) {
        double start = 0.2;
        double finish = 2.8;
        double step = 0.002;
        double[] x = fp5.writeX(start, finish, step);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForWriteY", dataProviderClass = StaticDataProvider05.class)
    public void testWriteY(int index, double expected) {
        double start = 0.2;
        double finish = 2.8;
        double step = 0.002;
        double[] x = fp5.writeX(start, finish, step);
        double[] y = fp5.writeY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));

    }

    @Test(dataProvider = "dataForIndexMinY", dataProviderClass = StaticDataProvider05.class)
    public void testIndexMinY(double start, double finish, double step, int expected) {
        double [] x = fp5.writeX(start, finish, step);
        double [] y = fp5.writeY(x);
        int actual = fp5.findMinY(y);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForIndexMaxY", dataProviderClass = StaticDataProvider05.class)
    public void testIndexMaxY(double start, double finish, double step, int expected) {
        double [] x = fp5.writeX(start, finish, step);
        double [] y = fp5.writeY(x);
        int actual = fp5.findMaxY(y);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForMinYByX", dataProviderClass = StaticDataProvider05.class)
    public void testFindMinYByX(double start, double finish, double step, int expected) {
        double [] x = fp5.writeX(start, finish, step);
        int actual = fp5.findMinYByX(x);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForMaxYByX", dataProviderClass = StaticDataProvider05.class)
    public void testFindMaxYByX(double start, double finish, double step, int expected) {
        double [] x = fp5.writeX(start, finish, step);
        int actual = fp5.findMaxYByX(x);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticDataProvider05.class)
    public void testSum(double start, double finish, double step, double expected) {
        double [] x = fp5.writeX(start, finish, step);
        double [] y = fp5.writeY(x);
        double actual = fp5.sum(y);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForAvg", dataProviderClass = StaticDataProvider05.class)
    public void testAvg(double start, double finish, double step, double expected) {
        double [] x = fp5.writeX(start, finish, step);
        double [] y = fp5.writeY(x);
        double actual = fp5.avg(y);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSumByX", dataProviderClass = StaticDataProvider05.class)
    public void testSumByX(double start, double finish, double step, double expected) {
        double [] x = fp5.writeX(start, finish, step);
        double actual = fp5.sumByX(x);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForAvgByX", dataProviderClass = StaticDataProvider05.class)
    public void testAvgByX(double start, double finish, double step, double expected) {
        double [] x = fp5.writeX(start, finish, step);
        double actual = fp5.avgByX(x);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }



}
