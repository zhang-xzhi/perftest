package allen.perftest.testcase.memory;

import allen.perftest.AbstractPerfTestCaseFactory;

public class MMFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        for (int size = 1; size <= 1024 * 1024; size = size * 2) {
            add(new MM_Allocate(size));
            add(new MM_DirectBuffer(size));
        }
    }

}
