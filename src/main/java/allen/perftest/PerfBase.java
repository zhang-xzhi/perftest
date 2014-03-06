package allen.perftest;

public interface PerfBase {

    public String name();

    public void beforeRunSuite();

    public void run();

    public void afterRunSuite();

    public String des();

    public Object[] extraPara();
    
    public Control getControl();
}
