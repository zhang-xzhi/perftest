package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCase;
import allen.perftest.Control;

public class StringBuilderCat extends AbstractPerfTestCase {
    static StringBuilder t;
    private int          loop;

    public StringBuilderCat(int loop) {
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
        return "StringBuilder.append";
    }

    @Override
    public void beforeRunSuite() {
        t = new StringBuilder();
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
