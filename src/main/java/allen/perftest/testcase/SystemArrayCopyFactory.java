package allen.perftest.testcase;

import allen.perftest.AbstractPerfBaseFactory;

public class SystemArrayCopyFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {

        for (int i = 1; i <= 1; i++) {
            add(new SystemArrayCopy(512 * i));
        }
    }
}
