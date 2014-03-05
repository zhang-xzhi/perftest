package allen.perftest.testcase.list;

import java.util.List;

import allen.perftest.AbstractPerfBase;

abstract public class ListAdd extends AbstractPerfBase {
    protected List<String> list;

    public ListAdd() {
    }

    @Override
    public void run() {
        list.add("allen");
    }

}
