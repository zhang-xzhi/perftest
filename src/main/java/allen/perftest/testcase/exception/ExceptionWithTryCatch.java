package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCase;

public class ExceptionWithTryCatch extends AbstractPerfTestCase {
    static int        tem;
    final private int deepth;

    public ExceptionWithTryCatch(int deepth) {
        this.deepth = deepth;
    }

    private int f(int deepth) {
        if (deepth <= 0) {
            return tem;
        }
        tem += f(--deepth);
        return tem;
    }

    @Override
    public void run() {
        try {
            tem = f(deepth);
        } catch (Exception e) {
            //ignore.
        }
    }

    @Override
    public String des() {
        return "only try block.";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { deepth };
    }
}
