package allen.perftest.testcase.bytescopy;

import allen.perftest.AbstractPerfTestCaseFactory;

public class BytesCopyFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {

        for (int i = 1; i <= 10; i++) {
            add(new SystemArrayCopy(512 * i));
            add(new ForLoopBytesCopy(512 * i));
        }
    }
}
