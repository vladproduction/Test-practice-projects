package com.vladproduction.junitextensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import static java.lang.System.currentTimeMillis;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = Logger.getLogger(TimingExtension.class.getName());
    private static final String START_TIME = "start time";

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        getStore(extensionContext).put(START_TIME, currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Method method = extensionContext.getRequiredTestMethod();
        long start_time = getStore(extensionContext).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - start_time;
        logger.info( ()-> String.format("Method [%s] took [%s] millis", method.getName(), duration)  );
    }

    private ExtensionContext.Store getStore(ExtensionContext context){
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
}
