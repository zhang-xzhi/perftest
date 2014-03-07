package allen.perftest.testcase.math;

import allen.perftest.AbstractPerfTestCase;

public class Math_IntMultiply extends AbstractPerfTestCase {
    static int  t;

    private int x;
    private int y;

    public Math_IntMultiply(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        t = x * y;
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { x, y };
    }

    @Override
    public String des() {
        return x + "*" + y;
    }
}
