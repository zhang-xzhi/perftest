package allen.perftest.testcase.math;

import allen.perftest.AbstractPerfTestCaseFactory;

public class MathFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {

        for (int x = -17; x <= 17; x += 17) {
            for (int y = -17; y <= 17; y += 17) {
                add(new Math_IntMultiply(x, y));
            }
        }

        for (int x = -17; x <= 17; x += 17) {
            for (int y = -17; y <= 17; y += 17) {
                add(new Math_DoubleMultiply(x, y));
            }
        }
    }

}
