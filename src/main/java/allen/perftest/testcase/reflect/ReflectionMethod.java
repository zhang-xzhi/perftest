package allen.perftest.testcase.reflect;

import java.lang.reflect.Method;

import allen.perftest.AbstractPerfBase;

public class ReflectionMethod extends AbstractPerfBase {

    static Method m;

    public void fun() {
    }

    @Override
    public void run() {
        try {
            m = ReflectionMethod.class.getDeclaredMethod("fun", (Class[]) null);
            m.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String des() {
        return "getDeclaredMethod and setAccessible.";
    }

}
