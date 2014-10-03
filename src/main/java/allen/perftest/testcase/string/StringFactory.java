package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCaseFactory;

public class StringFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        for (int i = 1; i <= 4; i = i * 2) {
            add(new StringCat(i));
            add(new StringBufferCat(i));
            add(new StringBuilderCat(i));
        }
    }
}
