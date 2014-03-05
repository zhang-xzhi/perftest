package allen.perftest.testcase.reflect;

import allen.perftest.AbstractPerfBaseFactory;

public class ReflectionFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {

        add(new ReflectionField());
        add(new ReflectionFieldInvoke());
        add(new ReflectionField_DirectAccess());

        add(new ReflectionMethod());
        add(new ReflectionMethodInvoke());
        add(new ReflectionMethod_DirectAccess());

        add(new ReflectionConstructor());
        add(new ReflectionConstructorInvoke());
        add(new ReflectionConstructor_DirectAccess());

        add(new ReflectionNewInstance());
    }

}
