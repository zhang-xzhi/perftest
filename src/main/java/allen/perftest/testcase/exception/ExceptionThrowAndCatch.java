package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCase;

public class ExceptionThrowAndCatch extends AbstractPerfTestCase {
    static Exception t;

    @Override
    public void run() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            t = e;
        }
    }

    @Override
    public String des() {
        return "throw and catch exception.";
    }
}
