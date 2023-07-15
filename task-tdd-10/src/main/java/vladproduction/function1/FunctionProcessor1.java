package vladproduction.function1;

import vladproduction.AbstractFunctionProcessor;


public class FunctionProcessor1 extends AbstractFunctionProcessor {

    private final double EPS = 1e-6;
    private final double a = -0.5;
    private final double b = 2.0;
    @Override
    public double function(double x) {
        if(x<=0.7+EPS)return 1; //need to add EPS, so test could run with calculation error
        if(x>1.4+EPS)return Math.exp(a*x)*Math.cos(b*x);
        return a*x*x*Math.log(x);
    }
}
