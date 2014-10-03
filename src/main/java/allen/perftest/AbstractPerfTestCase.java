package allen.perftest;

abstract public class AbstractPerfTestCase implements PerfTestCase {

    protected Control control = new Control();

    public AbstractPerfTestCase() {
    }

    @Override
    public void beforeRunSuite() {
    }

    @Override
    public void afterRunSuite() {
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object[] extraPara() {
        return null;
    }

    @Override
    public Control getControl() {
        return control;
    }
}
