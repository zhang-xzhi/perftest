package allen.perftest.testcase;

import allen.perftest.AbstractPerfBase;

public class TimeMeasurementNanoTime extends AbstractPerfBase {
    static long t;

    @Override
    public void run() {
        t = System.nanoTime();
    }

    @Override
    public String des() {
        return "System.nanoTime().";
    }
}
