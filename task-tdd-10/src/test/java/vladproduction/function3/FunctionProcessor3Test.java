package vladproduction.function3;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionProcessor3Test {

    private FunctionProcessor3 fp3;
    private static final double EPS = 1e-6;

    @BeforeMethod
    public void setUp() {
        fp3 = new FunctionProcessor3();
    }
    @Test(dataProvider = "dataForFunction", dataProviderClass = StaticDataProvider03.class)
    public void testFunction(double x, double expected) {
        double actual = fp3.function(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider03.class)
    public void testSteps(double start, double finish, double step, int expectSteps) {
        int actualSteps = fp3.stepsCount(start, finish, step);
        assertThat(actualSteps).isEqualTo(expectSteps);
    }

    @Test(dataProvider = "dataForWriteX", dataProviderClass = StaticDataProvider03.class)
    public void testWriteX(int index, double expected) {
        double start = 0.0;
        double finish = 2.0;
        double step = 0.002;
        double[] x = fp3.writeX(start, finish, step);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForWriteY", dataProviderClass = StaticDataProvider03.class)
    public void testWriteY(int index, double expected) {
        double start = 0.0;
        double finish = 2.0;
        double step = 0.002;
        double[] x = fp3.writeX(start, finish, step);
        double[] y = fp3.writeY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));

    }

    @Test(dataProvider = "dataForIndexMinY", dataProviderClass = StaticDataProvider03.class)
    public void testIndexMinY(double start, double finish, double step, int expected) {
        double [] x = fp3.writeX(start, finish, step);
        double [] y = fp3.writeY(x);
        int actual = fp3.findMinY(y);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForIndexMaxY", dataProviderClass = StaticDataProvider03.class)
    public void testIndexMaxY(double start, double finish, double step, int expected) {
        double [] x = fp3.writeX(start, finish, step);
        double [] y = fp3.writeY(x);
        int actual = fp3.findMaxY(y);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForMinYByX", dataProviderClass = StaticDataProvider03.class)
    public void testFindMinYByX(double start, double finish, double step, int expected) {
        double [] x = fp3.writeX(start, finish, step);
        int actual = fp3.findMinYByX(x);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForMaxYByX", dataProviderClass = StaticDataProvider03.class)
    public void testFindMaxYByX(double start, double finish, double step, int expected) {
        double [] x = fp3.writeX(start, finish, step);
        int actual = fp3.findMaxYByX(x);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticDataProvider03.class)
    public void testSum(double start, double finish, double step, double expected) {
        double [] x = fp3.writeX(start, finish, step);
        double [] y = fp3.writeY(x);
        double actual = fp3.sum(y);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForAvg", dataProviderClass = StaticDataProvider03.class)
    public void testAvg(double start, double finish, double step, double expected) {
        double [] x = fp3.writeX(start, finish, step);
        double [] y = fp3.writeY(x);
        double actual = fp3.avg(y);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSumByX", dataProviderClass = StaticDataProvider03.class)
    public void testSumByX(double start, double finish, double step, double expected) {
        double [] x = fp3.writeX(start, finish, step);
        double actual = fp3.sumByX(x);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForAvgByX", dataProviderClass = StaticDataProvider03.class)
    public void testAvgByX(double start, double finish, double step, double expected) {
        double [] x = fp3.writeX(start, finish, step);
        double actual = fp3.avgByX(x);
        assertThat(actual).isCloseTo(expected,Offset.offset(EPS));
    }


}
