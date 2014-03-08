package allen.perftest.testcase.time;

import allen.perftest.AbstractPerfTestCaseFactory;

public class TimeFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        add(new Time_CurrentTimeMillis());
        add(new Time_NanoTime());
        add(new Time_NewDate());
    }

}
