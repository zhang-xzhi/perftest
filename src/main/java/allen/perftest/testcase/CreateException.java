package allen.perftest.testcase;

import allen.perftest.AbstractPerfTestCase;

public class CreateException extends AbstractPerfTestCase {
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