package allen.perftest.testcase;

import allen.perftest.AbstractPerfBase;

public class CreateException extends AbstractPerfBase {
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