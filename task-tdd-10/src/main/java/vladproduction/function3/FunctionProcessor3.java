package vladproduction.function3;

import vladproduction.AbstractFunctionProcessor;


public class FunctionProcessor3 extends AbstractFunctionProcessor {

    private final double EPS = 1e-6;
    private final double a = 2.7;
    private final double b = -0.3;
    private final double c = 4.0;
    @Override
    public double function(double x) {
        if(x<1.4+EPS)return a*x*x+b*x+c;
        if(x>1.4+EPS)return (a+b*x)/Math.sqrt(x*x+1);
        return a/x+Math.sqrt(x*x+1);
    }
}
