package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCase;
import allen.perftest.Control;

public class StringBufferCat extends AbstractPerfTestCase {
    static StringBuffer t;
    private int         loop;

    public StringBufferCat(int loop) {
        super();
        this.loop = loop;
    }

    @Override
    public void run() {
        for (int i = 0; i < loop; i++) {
            t.append("allen");
        }
    }

    @Override
    public String des() {
        return "StringBuffer.append";
    }

    @Override
    public void beforeRunSuite() {
        t = new StringBuffer();
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { loop };
    }

    @Override
    public Control getControl() {
        return Control.controlForString();
    }
}
