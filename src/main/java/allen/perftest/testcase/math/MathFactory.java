package allen.perftest.testcase.math;

import allen.perftest.AbstractPerfBaseFactory;

public class MathFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {

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
