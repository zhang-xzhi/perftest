package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfTestCase;

public class ReflectionField_DirectAccess extends AbstractPerfTestCase {

    static Object o;

    public String name;

    @Override
    public void run() {
        o = name;
    }

    @Override
    public String des() {
        return "direct access field.";
    }

}
