package allen.perftest.testcase.list;

import allen.perftest.AbstractPerfTestCaseFactory;

public class ListFactory extends AbstractPerfTestCaseFactory {

    @Override
    public void fillPerfTestCase() {
        add(new ListAddArrayList(10));
        add(new ListAddArrayList(1000));
        add(new ListAddArrayList(10000));
        add(new ListAddArrayList(100000));
        add(new ListAddLinkedList());
    }
}
