package allen.perftest.testcase.reflect;

import java.lang.reflect.Constructor;

import allen.perftest.AbstractPerfBase;

public class ReflectionConstructor extends AbstractPerfBase {

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
