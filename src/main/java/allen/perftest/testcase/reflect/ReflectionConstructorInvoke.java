package allen.perftest.testcase.reflect;

import java.lang.reflect.Constructor;

import allen.perftest.AbstractPerfBase;

public class ReflectionConstructorInvoke extends AbstractPerfBase {

    static Constructor<ReflectionConstructorInvoke> c;
    static Object                                   o;
    static {
        try {
            c = ReflectionConstructorInvoke.class
                    .getConstructor((Class[]) null);
            c.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            o = c.newInstance((Object[]) null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String des() {
        return "constructor.newInstance";
    }

}
