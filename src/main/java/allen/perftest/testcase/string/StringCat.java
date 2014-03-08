package allen.perftest.testcase.string;

import allen.perftest.AbstractPerfTestCase;
import allen.perftest.Control;

public class StringCat extends AbstractPerfTestCase {
    static String t;
    private int   loop;

    public StringCat(int loop) {
        super();
        this.loop = loop;
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
    public void beforeRunSuite() {
        t = "";
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
