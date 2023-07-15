package vladproduction.function5;

import vladproduction.AbstractFunctionProcessor;


public class FunctionProcessor5 extends AbstractFunctionProcessor {

    private final double EPS = 1e-6;
    private final double a = 2.3;

    @Override
    public double function(double x) {
        if(x <= 0.3+EPS)return 1.5*a*Math.cos(x)*Math.cos(x);
        if(x>2.3+EPS)return 3*a*Math.tan(x);
        return (x-2)*(x-2)+6*a;
    }
}
