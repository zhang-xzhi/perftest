package allen.perftest.testcase.math;

import allen.perftest.AbstractPerfBase;

public class Math_IntMultiply extends AbstractPerfBase {
    static int t;

    @Override
    public void run() {
        t = 17 * 17;
    }

    @Override
    public String des() {
        return "17*17.";
    }
}
