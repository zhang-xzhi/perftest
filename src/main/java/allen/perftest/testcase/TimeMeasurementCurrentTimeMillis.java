package allen.perftest.testcase;

import allen.perftest.AbstractPerfBase;

public class TimeMeasurementCurrentTimeMillis extends AbstractPerfBase {
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
