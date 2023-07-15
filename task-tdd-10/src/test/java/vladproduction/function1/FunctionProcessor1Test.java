package vladproduction.function1;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;


public class FunctionProcessor1Test {

    private FunctionProcessor1 fp1;
    private static final double EPS = 1e-6; //10^-6

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

    @Test
    public void testFindMinY() {

        int minIndex = fp1.findMinY(new double[]{2, 3, 5, 11, -6, 0, 55});
        assertThat(minIndex).isEqualTo(4);
    }

    @Test
    public void testFindMaxY() {
        assertThat(fp1.findMaxY(new double[]{2, 3, 5, 11, -6, 0, 55})).isEqualTo(6);
    }

    @Test
    public void testSum() {
        assertThat(fp1.sum(new double[]{2, 3, 5, 11, -6, 0, 55})).isEqualTo(70);
    }

    @Test
    public void testAvg() {
        assertThat(fp1.avg(new double[]{2, 3, 5, 11, -6, 0, 55})).isEqualTo(10);
    }

    @Test
    public void testFindMinYByX() {

        int minIndex = fp1.findMinYByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(minIndex).isEqualTo(4);
    }

    @Test
    public void testFindMaxYByX() {

        int maxIndex = fp1.findMaxYByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(maxIndex).isEqualTo(2);
    }

    @Test
    public void testSumByX() {

        double sumByX = fp1.sumByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(sumByX).isEqualTo(4.629046458032491);
    }

    @Test
    public void testAvgByX() {

        double avgByX = fp1.avgByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(avgByX).isEqualTo(0.4629046458032491);
    }


}








