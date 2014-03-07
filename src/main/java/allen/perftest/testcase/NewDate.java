package allen.perftest.testcase;

import java.util.Date;

import allen.perftest.AbstractPerfTestCase;

public class NewDate extends AbstractPerfTestCase {
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
