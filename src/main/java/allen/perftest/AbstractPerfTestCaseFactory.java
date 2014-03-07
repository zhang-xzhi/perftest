package allen.perftest;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractPerfTestCaseFactory implements PerfTestCaseFactory {

    private List<PerfTestCase> list = new ArrayList<PerfTestCase>();

    @Override
    final public List<PerfTestCase> getPerfTestCaseList() {
        fillPerfTestCase();
        return list;
    }

    abstract public void fillPerfTestCase();

    final public void add(PerfTestCase perfTestCase) {
        list.add(perfTestCase);
    }
}
