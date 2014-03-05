package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfBase;

public class ReflectionConstructor_DirectAccess extends AbstractPerfBase {

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
