package allen.perftest;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractPerfBaseFactory implements PerfBaseFactory {

    private List<PerfBase> list = new ArrayList<PerfBase>();

    @Override
    final public List<PerfBase> getPerfBase() {
        fillPerfBase();
        return list;
    }

    abstract public void fillPerfBase();

    final public void add(PerfBase perfBase) {
        list.add(perfBase);
    }
}
