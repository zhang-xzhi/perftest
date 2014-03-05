package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfBase;

public class ExceptionOnlyCreateException extends AbstractPerfBase {
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
