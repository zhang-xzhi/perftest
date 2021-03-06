package allen.perftest.testcase.memory;

import allen.perftest.AbstractPerfTestCase;

public class MM_Allocate extends AbstractPerfTestCase {
    static byte[] t;
    private int   size;

    public MM_Allocate(int size) {
        super();
        this.size = size;
    }

    @Override
    public void run() {
        t = new byte[size];
    }

    @Override
    public String des() {
        return "allocate memory using new byte[size]";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { size };
    }
}
