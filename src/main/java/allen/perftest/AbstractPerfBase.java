package allen.perftest;

abstract public class AbstractPerfBase implements PerfBase {

    public AbstractPerfBase() {
    }

    @Override
    public void beforeRunSuite() {
    }

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

    public Control getControl() {
        return Control.defaultControl();
    }
}
