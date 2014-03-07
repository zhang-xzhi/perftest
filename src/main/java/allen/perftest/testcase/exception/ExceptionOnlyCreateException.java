package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCase;

public class ExceptionOnlyCreateException extends AbstractPerfTestCase {
    static Exception t;

    @Override
    public void run() {
        t = new Exception();
    }

    @Override
    public String des() {
        return "only create exception.";
    }
}
