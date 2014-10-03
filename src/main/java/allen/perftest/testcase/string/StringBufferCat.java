package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCase;

public class StringBufferCat extends AbstractPerfTestCase {

    private StringBuffer t;
    private int          loop;

    public StringBufferCat(int loop) {
        this.loop = loop;
    }

    @Override
    public void beforeRunSuite() {
        t = new StringBuffer();
    }

    @Override
    public void afterRunSuite() {
        System.out.println(t.length());
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
    public Object[] extraPara() {
        return new Object[] { loop };
    }

}
