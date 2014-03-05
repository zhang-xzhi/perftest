package allen.perftest.testcase.bytescopy;

import allen.perftest.AbstractPerfBase;

public class SystemArrayCopy extends AbstractPerfBase {
    int    size;
    byte[] data;
    byte[] des;

    public SystemArrayCopy(int size) {
        this.size = size;
        data = new byte[size];
        des = new byte[size];
    }

    @Override
    public void run() {
        System.arraycopy(data, 0, des, 0, data.length);
    }

    @Override
    public String des() {
        return "System.arraycopy(). size";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { size };
    }
}
