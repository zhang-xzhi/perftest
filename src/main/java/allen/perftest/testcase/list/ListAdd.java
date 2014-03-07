package allen.perftest.testcase.list;

import java.util.List;

import allen.perftest.AbstractPerfTestCase;

abstract public class ListAdd extends AbstractPerfTestCase {
    protected List<String> list;

    public ListAdd() {
    }

    @Override
    public void run() {
        list.add("allen");
    }

}
