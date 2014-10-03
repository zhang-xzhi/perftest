package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCase;

public class StringBuilderCat extends AbstractPerfTestCase {
    private StringBuilder t;
    private int           loop;

    public StringBuilderCat(int loop) {
        this.loop = loop;
    }

    @Override
    public void beforeRunSuite() {
        t = new StringBuilder();
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
        return "StringBuilder.append";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { loop };
    }

}
