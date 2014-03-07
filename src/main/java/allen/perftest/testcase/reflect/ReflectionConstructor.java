package allen.perftest.testcase.reflect;

import java.lang.reflect.Constructor;

import allen.perftest.AbstractPerfTestCase;

public class ReflectionConstructor extends AbstractPerfTestCase {

    static Constructor<ReflectionConstructor> c;

    @Override
    public void run() {
        try {
            c = ReflectionConstructor.class.getConstructor((Class[]) null);
            c.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String des() {
        return "class.getConstructor";
    }

}
