package allen.perftest.testcase.bytescopy;

import allen.perftest.AbstractPerfBase;

public class ForLoopBytesCopy extends AbstractPerfBase {
    int    size;
    byte[] data;
    byte[] des;

    public ForLoopBytesCopy(int size) {
        this.size = size;
        data = new byte[size];
        des = new byte[size];
    }

    @Override
    public void run() {
        for (int i = 0; i < des.length; i++) {
            des[i] = data[i];
        }
    }

    @Override
    public String des() {
        return "for loop bytes copy. size";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { size };
    }
}