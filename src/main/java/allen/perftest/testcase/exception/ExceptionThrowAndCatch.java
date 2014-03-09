package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCase;

public class ExceptionThrowAndCatch extends AbstractPerfTestCase {
    static int        tem;
    final private int deepth;

    public ExceptionThrowAndCatch(int deepth) {
        this.deepth = deepth;
    }

    private int f(int deepth) {
        if (deepth <= 0) {
            throw new RuntimeException();
        }
        tem += f(--deepth);
        return tem;
    }

    @Override
    public void run() {
        try {
            f(deepth);
        } catch (Exception e) {
            //ignore.
        }
    }

    @Override
    public String des() {
        return "throw and catch exception.";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { deepth };
    }
}
