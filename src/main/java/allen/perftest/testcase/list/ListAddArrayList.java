package allen.perftest.testcase.list;

import java.util.ArrayList;

public class ListAddArrayList extends ListAdd {

    protected int initialCapacity;

    public ListAddArrayList(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    @Override
    public void reset() {
        list = new ArrayList<String>(this.initialCapacity);
    }

    @Override
    public String name() {
        return super.name() + "_initialCapacity = " + initialCapacity;
    }

    @Override
    public String des() {
        return "arrayList.add()";
    }
}
