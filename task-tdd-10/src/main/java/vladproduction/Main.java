package vladproduction;


public class Main {
    public static void main(String[] args) {

        //choose function:
        FunctionProcessor fp = FunctionProcessorFactory.getFunctionProcessor(5);

        //set up 'x' value:
        double x = 2.0;
        double y = fp.function(x);
        System.out.println("function("+x+") = "+ y);


        //set up 'bounds' to:
        double start = 0.2;
        double finish = 2.8;
        double step = 0.002;
        int steps = fp.stepsCount(start,finish,step);
        System.out.println("stepsCount("+start+","+finish+","+step+") = "+steps);

        //creating arrays:
        double [] xArray = fp.writeX(start,finish,step);
        double [] yArray = fp.writeY(xArray);
//        System.out.println(Arrays.toString(xArray));
//        System.out.println(Arrays.toString(yArray));


        System.out.println("-----indexes-----");
        int minIndex = fp.findMinY(yArray);
        int findMinYByX = fp.findMinYByX(xArray);
        System.out.println("minIndex Y = "+minIndex);
        System.out.println("minIndex YByX = "+findMinYByX);
        int maxIndex = fp.findMaxY(yArray);
        int findMaxYByX = fp.findMaxYByX(xArray);
        System.out.println("maxIndex Y = "+maxIndex);
        System.out.println("maxIndex YByX = "+findMaxYByX);


        System.out.println("-----'Y' values-----");
        double minYValue = fp.minYValue(xArray);
        System.out.println("minY = "+minYValue);
        double maxYValue = fp.maxYValue(xArray);
        System.out.println("maxY = "+maxYValue);


        System.out.println("-----'X' values-----");
        double minXValue = fp.minXValue(xArray);
        System.out.println("minX = " + minXValue);
        double maxXValue = fp.maxXValue(xArray);
        System.out.println("maxX = " + maxXValue);


        System.out.println("-----sum, avg-----");
        double sum = fp.sum(yArray);
        double sumByX = fp.sumByX(xArray);
        System.out.println("sum = "+sum);
        System.out.println("sumByX = "+sumByX);
        double avg = fp.avg(yArray);
        double avgByX = fp.avgByX(xArray);
        System.out.println("avg = "+avg);
        System.out.println("avgByX = "+avgByX);
    }
}
