package allen.perftest.testcase.time;

import allen.perftest.AbstractPerfTestCase;

public class Time_NanoTime extends AbstractPerfTestCase {
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
