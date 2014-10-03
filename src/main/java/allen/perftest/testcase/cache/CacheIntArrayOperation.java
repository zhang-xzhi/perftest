package allen.perftest.testcase.cache;

import allen.perftest.AbstractPerfTestCase;

public class CacheIntArrayOperation extends AbstractPerfTestCase {

    private int[] arr;
    private int   step;

    public CacheIntArrayOperation(int step) {
        this.step = step;
    }

    @Override
    public void beforeRunSuite() {
        arr = new int[4 * 1024 * 1024];
    }

    @Override
    public void afterRunSuite() {
        arr = null;
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
