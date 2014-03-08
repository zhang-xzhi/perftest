package allen.perftest.testcase.time;

import java.util.Date;

import allen.perftest.AbstractPerfTestCase;

public class Time_NewDate extends AbstractPerfTestCase {
    static Date t;

    @Override
    public void run() {
        t = new Date();
    }

    @Override
    public String des() {
        return "new Date().";
    }
}
