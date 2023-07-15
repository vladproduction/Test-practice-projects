package vladproduction;

import vladproduction.function1.FunctionProcessor1;
import vladproduction.function3.FunctionProcessor3;
import vladproduction.function5.FunctionProcessor5;

public class FunctionProcessorFactory {

    public static FunctionProcessor getFunctionProcessor(int type){
        switch (type){
            case 1: return new FunctionProcessor1();
            case 3: return new FunctionProcessor3();
            case 5: return new FunctionProcessor5();
            default : throw new IllegalArgumentException("Not supported type = "+type);
        }
    }
}
