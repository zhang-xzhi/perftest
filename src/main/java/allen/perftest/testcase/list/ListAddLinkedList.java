package allen.perftest.testcase.list;

import java.util.LinkedList;

public class ListAddLinkedList extends ListAdd {

    public ListAddLinkedList() {
    }

    @Override
    public void reset() {
        list = new LinkedList<String>();
    }

    @Override
    public String des() {
        return "linkedList.add()";
    }
}
