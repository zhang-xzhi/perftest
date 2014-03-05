package allen.perftest.testcase.exception;

import allen.perftest.AbstractPerfBaseFactory;

public class ExceptionFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {
        add(new ExceptionThrowAndCatch());
        add(new ExceptionWithTryCatch());
        add(new ExceptionOnlyCreateException());
    }
}
