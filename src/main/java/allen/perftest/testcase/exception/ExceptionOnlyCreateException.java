package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCase;

public class ExceptionOnlyCreateException extends AbstractPerfTestCase {
    static Exception  t;
    final private int deepth;

    public ExceptionOnlyCreateException(int deepth) {
        this.deepth = deepth;
    }

    private Exception f(int deepth) {
        if (deepth <= 0) {
            return new RuntimeException();
        }
        Exception tem = f(--deepth);
        if (tem == null) {
            return null;
        } else {
            return tem;
        }
    }

    @Override
    public void run() {
        t = f(deepth);
    }

    @Override
    public String des() {
        return "only create exception.";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { deepth };
    }
}
