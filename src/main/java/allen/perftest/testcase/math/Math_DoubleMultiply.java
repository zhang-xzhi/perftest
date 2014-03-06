package allen.perftest.testcase.math;

import allen.perftest.AbstractPerfBase;

public class Math_DoubleMultiply extends AbstractPerfBase {
    static double  t;

    private double x;
    private double y;

    public Math_DoubleMultiply(double x, double y) {
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
