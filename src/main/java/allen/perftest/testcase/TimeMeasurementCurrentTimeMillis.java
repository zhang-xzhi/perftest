package allen.perftest.testcase;

import allen.perftest.AbstractPerfTestCase;

public class TimeMeasurementCurrentTimeMillis extends AbstractPerfTestCase {
    static long t;

    @Override
    public void run() {
        t = System.currentTimeMillis();
    }

    @Override
    public String des() {
        return "System.currentTimeMillis().";
    }
}
