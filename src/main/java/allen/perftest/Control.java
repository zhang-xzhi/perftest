package allen.perftest;

public class Control {
    public final static int LoopMaxLimit = 10000000;

    public static Control defaultControl() {
        Control c = new Control();
        c.curLoop = 0;
        c.loopStep = 10000;
        c.consumingTimeDeltaLimit = 0.2D;
        c.testSuiteCount = 5;
        return c;
    }

    public static Control controlForCache() {
        Control c = new Control();
        c.curLoop = 0;
        c.loopStep = 1;
        c.consumingTimeDeltaLimit = 0.2D;
        c.testSuiteCount = 1;
        return c;
    }

    protected int    curLoop;
    protected int    loopStep;
    protected int    testSuiteCount;
    protected double consumingTimeDeltaLimit;

    public boolean canStep() {
        return curLoop + loopStep <= LoopMaxLimit;
    }

    public void step() {
        curLoop += loopStep;
    }

    public int getCurLoop() {
        return curLoop;
    }

    public double getConsumingTimeDeltaLimit() {
        return consumingTimeDeltaLimit;
    }

    public int getTestSuiteCount() {
        return testSuiteCount;
    }

    public String getDes() {
        return "loop=" + curLoop + " suite=" + testSuiteCount + " delta="
                + consumingTimeDeltaLimit;
    }

    public void gc() {
        System.gc();
        System.gc();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Control() {
    }
}
