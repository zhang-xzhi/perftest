package allen.perftest.testcase.list;

import allen.perftest.AbstractPerfBaseFactory;

public class ListAddFactory extends AbstractPerfBaseFactory {

    @Override
    public void fillPerfBase() {
        add(new ListAddArrayList(10));
        add(new ListAddArrayList(1000));
        add(new ListAddArrayList(100000));
        add(new ListAddLinkedList());
    }
}
