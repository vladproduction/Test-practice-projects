package vladproduction.function1;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MainTest01 {

    Main01 main = new Main01();
    public static final double EPS = 1e-6; //10^-6

    @BeforeMethod
    public void setUp() {
        main = new Main01();
    }

    @Test(dataProvider = "dataForFunction", dataProviderClass = StaticDataProvider01.class)
    public void testFunction(double x, double expected) {
        double actual = main.function(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider01.class)
    public void testSteps(double start, double finish, double step, int expectSteps) {
        int actualSteps = main.stepsCount(start, finish, step);
        assertThat(actualSteps).isEqualTo(expectSteps);
    }

    @Test(dataProvider = "dataForWriteX", dataProviderClass = StaticDataProvider01.class)
    public void testWriteX(int index, double expected){
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;
        double [] x = main.writeX(start, finish, step);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForWriteY", dataProviderClass = StaticDataProvider01.class)
    public void testWriteY(int index, double expected){
        double start = 0.0;
        double finish = 3.0;
        double step = 0.004;
        double [] x = main.writeX(start, finish, step);
        double [] y = main.writeY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));

    }

    @Test(dataProvider = "findIndexMax", dataProviderClass = StaticDataProvider01.class)
    public void testFindIndexMax(){

    }

}








