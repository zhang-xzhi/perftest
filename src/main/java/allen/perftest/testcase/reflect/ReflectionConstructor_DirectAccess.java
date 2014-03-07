package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfTestCase;

public class ReflectionConstructor_DirectAccess extends AbstractPerfTestCase {

    static Object o;

    @Override
    public void run() {
        o = new ReflectionConstructor_DirectAccess();
    }

    @Override
    public String des() {
        return "direct access constructor.";
    }

}
