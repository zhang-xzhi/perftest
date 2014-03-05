package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfBase;

public class ReflectionMethod_DirectAccess extends AbstractPerfBase {

    static Object o;

    public String fun() {
        return null;
    }

    @Override
    public void run() {
        o = fun();
    }

    @Override
    public String des() {
        return "direct access method.";
    }

}
