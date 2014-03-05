package allen.perftest.testcase.cache;

import allen.perftest.AbstractPerfBaseFactory;

public class CacheFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {
        for (int step = 1; step < 10; step++) {
            add(new CacheIntArrayOperation(step));
        }
    }

}
