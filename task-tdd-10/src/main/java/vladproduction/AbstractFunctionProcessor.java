package vladproduction;

import java.util.stream.IntStream;

public abstract class AbstractFunctionProcessor implements FunctionProcessor {


    @Override
    public int stepsCount(double start, double finish, double step) {
        return (int)(Math.round((finish-start)/step) + 1);
    }

    @Override
    public double[] writeX(double start, double finish, double step) {
        return IntStream.range(0,stepsCount(start, finish, step)).
                mapToDouble(i-> start + i * step).
                toArray();
    }

    @Override
    public double[] writeY(double[] x) {
        double [] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = function(x[i]);
        }
        return y;
        //return DoubleStream.of(x).map(this::function).toArray();
    }

    @Override
    public int findMinY(double[] y) {
        double min = y[0];
        int minIndex = 0;
        for (int i = 1; i < y.length; i++) {
            if(y[i]<min){
                min = y[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Override
    public int findMaxY(double[] y) {
        double max = y[0];
        int maxIndex = 0;
        for (int i = 1; i < y.length; i++) {
            if(y[i]>max){
                max = y[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public int findMinYByX(double[] x) {
        double [] y = writeY(x);
        return findMinY(y);
    }

    @Override
    public int findMaxYByX(double[] x) {
        double [] y = writeY(x);
        return findMaxY(y);
    }

    @Override
    public double minYValue(double[] x) {
        double [] y = writeY(x);
        int minIndex = findMinY(y);
        return y[minIndex];
    }

    @Override
    public double maxYValue(double[] x) {
        double [] y = writeY(x);
        int maxIndex = findMaxY(y);
        return y[maxIndex];
    }

    @Override
    public double minXValue(double [] x){
        int minIndex = findMinYByX(x);
        return x[minIndex];
    }
    @Override
    public double maxXValue(double [] x){
        int maxIndex = findMaxYByX(x);
        return x[maxIndex];
    }
    @Override
    public double sum(double[] y) {
        double sum = 0;
        for (int i = 0; i < y.length; i++) {
            sum += y[i];
        }
        return sum;
    }

    @Override
    public double avg(double[] y) {
        return sum(y)/y.length;
    }

    @Override
    public double sumByX(double[] x) {
        double [] y = writeY(x);
        return sum(y);
    }

    @Override
    public double avgByX(double[] x) {
        double [] y = writeY(x);
        return avg(y);
    }
}
