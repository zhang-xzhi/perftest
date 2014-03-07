package allen.perftest.testcase;

import allen.perftest.AbstractPerfTestCase;

public class TimeMeasurementNanoTime extends AbstractPerfTestCase {
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
