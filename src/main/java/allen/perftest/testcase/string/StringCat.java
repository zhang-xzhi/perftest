package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCase;

public class StringCat extends AbstractPerfTestCase {
    private String t;
    private int    loop;

    public StringCat(int loop) {
        this.loop = loop;
    }

    @Override
    public void beforeRunSuite() {
        t = "";
    }

    @Override
    public void afterRunSuite() {
        System.out.println(t.length());
    }

    @Override
    public void run() {
        for (int i = 0; i < loop; i++) {
            t += "allen";
        }
    }

    @Override
    public String des() {
        return "string+string";
    }

    @Override
    public Object[] extraPara() {
        return new Object[] { loop };
    }

}
