package vladproduction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FunctionProcessor fp = FunctionProcessorFactory.getFunctionProcessor(5);
        double x = 2.0;
        double y = fp.function(x);
        System.out.println("function("+x+") = "+ y);
        double [] xArray = new double[10];
        xArray[0] = 0.9;
        xArray[1] = 2.0;
        xArray[2] = 0.7;
        xArray[3] = 1.1;
        xArray[4] = 1.4;
        xArray[5] = 0.0;
        xArray[6] = -2.0;
        xArray[7] = -0.8;
        xArray[8] = 3.0;
        xArray[9] = -1.5;

        double [] yArray = fp.writeY(xArray);
        System.out.println(Arrays.toString(xArray));
        System.out.println(Arrays.toString(yArray));

        System.out.println("------find minIndex---------");
        int minIndex = fp.findMinY(yArray);
        int minIndexByX = fp.findMinYByX(xArray);
        System.out.println("minIndex = "+minIndex);
        System.out.println("minIndexByX = "+minIndexByX);

        System.out.println("------find maxIndex---------");
        int maxIndex = fp.findMaxY(yArray);
        int maxIndexByX = fp.findMaxYByX(xArray);
        System.out.println("maxIndex = "+maxIndex);
        System.out.println("maxIndexByX = "+maxIndexByX);

        System.out.println("------find sum---------");
        double sum = fp.sum(yArray);
        double sumByX = fp.sumByX(xArray);
        System.out.println("sum = "+sum);
        System.out.println("sumByX = "+sumByX);

        System.out.println("------find avg---------");
        double avg = fp.avg(yArray);
        double avgByX = fp.avgByX(xArray);
        System.out.println("avg = "+avg);
        System.out.println("avgByX = "+avgByX);

        System.out.println("---minYValue-------");
        double minYValue = fp.minYValue(xArray);
        System.out.println("minYValue = "+minYValue);

        System.out.println("---maxYValue-------");
        double maxYValue = fp.maxYValue(xArray);
        System.out.println("maxYValue = "+maxYValue);


    }
}
