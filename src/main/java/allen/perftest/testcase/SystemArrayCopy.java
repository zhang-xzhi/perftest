package allen.perftest.testcase;

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
    public String name() {
        return super.name() + "_data size = " + size;
    }

    @Override
    public String des() {
        return "System.arraycopy()";
    }
}
