package vladproduction.function3;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vladproduction.function1.FunctionProcessor1;
import vladproduction.function1.StaticDataProvider01;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionProcessor3Test {



    private FunctionProcessor3 fp3;
    private static final double EPS = 1e-6; //10^-6

    @BeforeMethod
    public void setUp() {
        fp3 = new FunctionProcessor3();
    }

//    @Test(dataProvider = "dataForFunction", dataProviderClass = StaticDataProvider01.class)
//    public void testFunction(double x, double expected) {
//        double actual = fp3.function(x);
//        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
//    }

//    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider01.class)
//    public void testSteps(double start, double finish, double step, int expectSteps) {
//        int actualSteps = fp3.stepsCount(start, finish, step);
//        assertThat(actualSteps).isEqualTo(expectSteps);
//    }

//    @Test(dataProvider = "dataForWriteX", dataProviderClass = StaticDataProvider01.class)
//    public void testWriteX(int index, double expected) {
//        double start = 0.0;
//        double finish = 3.0;
//        double step = 0.004;
//        double[] x = fp3.writeX(start, finish, step);
//        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
//    }

//    @Test(dataProvider = "dataForWriteY", dataProviderClass = StaticDataProvider01.class)
//    public void testWriteY(int index, double expected) {
//        double start = 0.0;
//        double finish = 3.0;
//        double step = 0.004;
//        double[] x = fp3.writeX(start, finish, step);
//        double[] y = fp3.writeY(x);
//        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));
//
//    }







    @Test
    public void testFindMinYByX() {

        int minIndex = fp3.findMinYByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(minIndex).isEqualTo(8);
    }

    @Test
    public void testFindMaxYByX() {

        int maxIndex = fp3.findMaxYByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(maxIndex).isEqualTo(6);
    }

    @Test
    public void testSumByX() {

        double sumByX = fp3.sumByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(sumByX).isEqualTo(64.24035852938022);
    }

    @Test
    public void testAvgByX() {

        double avgByX = fp3.avgByX(new double[]{0.9, 2.0, 0.7, 1.1, 1.4, 0.0, -2.0, -0.8, 3.0, -1.5});
        assertThat(avgByX).isEqualTo(6.4240358529380215);
    }


}
