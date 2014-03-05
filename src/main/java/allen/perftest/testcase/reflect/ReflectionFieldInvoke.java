package allen.perftest.testcase.reflect;

import java.lang.reflect.Field;

import allen.perftest.AbstractPerfBase;

public class ReflectionFieldInvoke extends AbstractPerfBase {

    static Field  f;
    static Object o;

    static {
        try {
            f = ReflectionFieldInvoke.class.getDeclaredField("name");
            f.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String name;

    @Override
    public void run() {
        try {
            o = f.get(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String des() {
        return "field.get().";
    }

}
