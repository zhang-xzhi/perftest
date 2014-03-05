package allen.perftest.testcase;

import java.util.Date;

import allen.perftest.AbstractPerfBase;

public class NewDate extends AbstractPerfBase {
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
