package allen.perftest.testcase.math;

import allen.perftest.AbstractPerfBaseFactory;

public class MathFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {
        add(new Math_IntMultiply());
    }

}
