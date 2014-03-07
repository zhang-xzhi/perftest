package allen.perftest;

public interface PerfTestCase {

    public String name();

    public void beforeRunSuite();

    public void run();

    public void afterRunSuite();

    public String des();

    public Object[] extraPara();
    
    public Control getControl();
}
