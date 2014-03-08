package allen.perftest.testcase.memory;

import allen.perftest.AbstractPerfTestCase;

public class MM_Alocate extends AbstractPerfTestCase {
    static byte[] t;
    private int   size;

    public MM_Alocate(int size) {
        super();
        this.size = size;
    }

    @Override
    public void run() {
        t = new byte[size];
    }

    @Override
    public String des() {
        return "alocate memory.";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { size };
    }
}
