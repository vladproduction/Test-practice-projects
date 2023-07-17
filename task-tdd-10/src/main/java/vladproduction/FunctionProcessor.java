package vladproduction;


public interface FunctionProcessor {

    public double function(double x);

    public int stepsCount(double start, double finish, double step);

    public double[] writeX(double start, double finish, double step);

    public double[] writeY(double[] x);

    public int findMinY(double [] y);

    public int findMaxY(double [] y);

    public int findMinYByX(double [] x);

    public int findMaxYByX(double [] x);

    public double minYValue(double [] x);

    public double maxYValue(double [] x);

    public double minXValue(double [] x);

    public double maxXValue(double [] x);

    public double sum (double [] y);

    public double avg (double [] y);

    public double sumByX (double [] x);

    public double avgByX (double [] x);
}
