package allen.perftest;

import allen.perftest.result.PerftestResult;

public class Control {
    private final static long   Default_Loop_Max_Limit   = Long.MAX_VALUE;
    private final static int    Adjust_Max_Limit         = 5;

    /**
     * 执行一个suite的最短时间。
     * 
     * <pre>
     * 1s。
     * </pre>
     * */
    private final static double Min_RunTime_For_Suite    = 1000000000D;
    /**
     * 执行一个suite的期望时间。
     * 
     * <pre>
     * 2s。
     * </pre>
     * */
    private final static double Expect_RunTime_For_Suite = 2000000000D;

    //trigger JIT
    protected long              warmupLoop               = 10000;

    protected long              curLoop;

    protected int               suiteCount               = 5;

    protected boolean           needGcBeforeRun          = false;

    private int                 adjustCounter;

    public boolean isSatisfiedForResult(PerftestResult perftestResult) {
        return perftestResult.avg * curLoop >= Min_RunTime_For_Suite;
    }

    public void adjustForResult(PerftestResult perftestResult) {
        curLoop = curLoop + curLoop;
        adjustCounter++;
        if (adjustCounter > Adjust_Max_Limit) {
            throw new RuntimeException();
        }
    }

    /**
     * 调整curLoop.
     * 
     * <pre>
     * 期望一个suite可以在2s左右。
     * </pre>
     * */
    public void adjust(double consumeTime, long loop) {
        double avg = consumeTime / loop;

        double expectLoop = Expect_RunTime_For_Suite / avg;
        if (expectLoop >= Default_Loop_Max_Limit) {
            throw new RuntimeException();
        } else {
            curLoop = (long) expectLoop;
        }
    }

    public long getCurLoop() {
        return curLoop;
    }

    public int getSuiteCount() {
        return suiteCount;
    }

    public String getDes() {
        return "[" + "suite=" + suiteCount + " loop=" + curLoop + "]";
    }

    public long getWarmupLoop() {
        return warmupLoop;
    }

    public boolean isNeedGcBeforeRun() {
        return needGcBeforeRun;
    }

    public Control() {
    }
}
