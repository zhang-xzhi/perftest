package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfBase;

public class ExceptionWithTryCatch extends AbstractPerfBase {
    static Exception t;
    static int       totalSum;

    private int sum(int i, int j) throws Exception {
        return i + j;
    }

    @Override
    public void run() {
        try {
            totalSum = sum(0, 0);
        } catch (Exception e) {
            t = e;
        }
    }

    @Override
    public String des() {
        return "only try block.";
    }
}
