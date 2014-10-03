package allen.perftest.testcase.memory;

import java.nio.ByteBuffer;

import allen.perftest.AbstractPerfTestCase;

public class MM_DirectBuffer extends AbstractPerfTestCase {
    static ByteBuffer buffer;

    private int       size;

    public MM_DirectBuffer(int size) {
        super();
        this.size = size;
    }

    @Override
    public void run() {
        buffer = ByteBuffer.allocateDirect(size);
    }

    @Override
    public String des() {
        return "ByteBuffer.allocateDirect(size)";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { size };
    }

}
