package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCaseFactory;

public class ExceptionFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        add(new ExceptionThrowAndCatch());
        add(new ExceptionWithTryCatch());
        add(new ExceptionOnlyCreateException());
    }
}
