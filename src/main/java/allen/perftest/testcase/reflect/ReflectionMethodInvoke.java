package allen.perftest.testcase.reflect;

import java.lang.reflect.Method;

import allen.perftest.AbstractPerfTestCase;

public class ReflectionMethodInvoke extends AbstractPerfTestCase {

    static Method m;
    static Object o;
    static {
        try {
            m = ReflectionMethodInvoke.class.getDeclaredMethod("fun",
                    (Class[]) null);
            m.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String fun() {
        return null;
    }

    @Override
    public void run() {
        try {
            o = m.invoke(this, (Object[]) null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String des() {
        return "method.invoke().";
    }

}
