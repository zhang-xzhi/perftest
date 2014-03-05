package allen.perftest.testcase.cache;

import allen.perftest.AbstractPerfBase;

public class CacheIntArrayOperation extends AbstractPerfBase {
    public static int CacheLine = 64;
    private int[]     arr       = new int[CacheLine * 1024];
    private int       step;

    public CacheIntArrayOperation(int step) {
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i += step) {
            arr[i] *= 3;
        }

    }

    @Override
    public String des() {
        return "operate on int array. step";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { step };
    }
}
