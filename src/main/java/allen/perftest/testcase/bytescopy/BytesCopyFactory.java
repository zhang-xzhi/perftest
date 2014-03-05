package allen.perftest.testcase.bytescopy;

import allen.perftest.AbstractPerfBaseFactory;

public class BytesCopyFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {

        for (int i = 1; i <= 10; i++) {
            add(new SystemArrayCopy(512 * i));
            add(new ForLoopBytesCopy(512 * i));
        }
    }
}
