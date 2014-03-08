package allen.perftest.testcase.time;

import allen.perftest.AbstractPerfTestCase;

public class Time_CurrentTimeMillis extends AbstractPerfTestCase {
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
