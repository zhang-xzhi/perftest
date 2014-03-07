package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfTestCase;

public class ReflectionNewInstance extends AbstractPerfTestCase {

    static Object o;

    @Override
    public void run() {
        try {
            o = ReflectionNewInstance.class.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String des() {
        return "class.newInstance()";
    }
}
