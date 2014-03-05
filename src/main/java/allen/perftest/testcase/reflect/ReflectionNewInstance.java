package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfBase;

public class ReflectionNewInstance extends AbstractPerfBase {

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
