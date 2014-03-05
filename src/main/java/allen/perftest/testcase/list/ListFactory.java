package allen.perftest.testcase.list;

import allen.perftest.AbstractPerfBaseFactory;

public class ListFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {
        add(new ListAddArrayList(10));
        add(new ListAddArrayList(1000));
        add(new ListAddArrayList(10000));
        add(new ListAddArrayList(100000));
        add(new ListAddLinkedList());
    }
}
