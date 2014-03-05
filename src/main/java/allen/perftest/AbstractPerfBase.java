package allen.perftest;

abstract public class AbstractPerfBase implements PerfBase {

    private String name;

    public AbstractPerfBase(String name) {
        this.name = name;
    }

    public AbstractPerfBase() {
    }

    public void reset() {
    }

    @Override
    public String name() {
        if (name == null) {
            return this.getClass().getSimpleName();
        } else {
            return name;
        }
    }

    @Override
    public Object[] extraPara() {
        return null;
    }
}
