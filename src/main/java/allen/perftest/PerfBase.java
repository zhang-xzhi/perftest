package allen.perftest;

public interface PerfBase {

    public String name();

    public void run();

    public String des();

    public void reset();

    public Object[] extraPara();
}
