package allen.perftest.testcase.reflect;

import java.lang.reflect.Field;

import allen.perftest.AbstractPerfTestCase;

public class ReflectionField extends AbstractPerfTestCase {
    static Field  f;
    
    public String name;

    @Override
    public void run() {
        try {
            f = ReflectionField.class.getDeclaredField("name");
            f.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String des() {
        return "getDeclaredField and setAccessible.";
    }

}
