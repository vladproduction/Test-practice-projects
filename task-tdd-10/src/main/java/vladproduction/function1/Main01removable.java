package vladproduction.function1;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main01removable {

    private final double EPS = 1e-6;
    private final double a = -0.5;
    private final double b = 2.0;
    public double function(double x) {

        if(x<=0.7+EPS)return 1; //need to add EPS, so test could run with calculation error
        if(x>1.4+EPS)return Math.exp(a*x)*Math.cos(b*x);
        return a*x*x*Math.log(x);
    }

    public int stepsCount(double start, double finish, double step) {
        return (int)(Math.round((finish-start)/step) + 1);
    }

    public double[] writeX(double start, double finish, double step) {
        return IntStream.range(0,stepsCount(start, finish, step)).
                         mapToDouble(i-> start + i * step).
                         toArray();
    }

    public double[] writeY(double[] x) {
        return DoubleStream.of(x).map(this::function).toArray();
    }

    public int findIndexMaxValue(double[] y) {
        int res = 0;
        for (int i = 0; i < y.length; i++) {
            double max = y[i];
            int maxIndex = i;
            for (int j = i+1; j < y.length;j++){
                if(y[j]>max){
                    maxIndex = j;
                    max = y[j];
                }
            }
            if(maxIndex != i){
                swap(y, i,maxIndex);
                res = maxIndex;
            }
        }
        return res;
    }

    private static void swap(double[] data, int i, int j) {
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
}
