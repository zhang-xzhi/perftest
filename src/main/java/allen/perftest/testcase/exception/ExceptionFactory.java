package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfTestCaseFactory;

public class ExceptionFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        for (int i = 1; i <= 1024; i = i * 2) {
            add(new ExceptionThrowAndCatch(i));
            add(new ExceptionWithTryCatch(i));
            add(new ExceptionOnlyCreateException(i));
        }
    }
}
