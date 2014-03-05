package allen.perftest.result;

import java.util.Comparator;

public class PerftestResultNameComparator implements Comparator<PerftestResult> {

    @Override
    public int compare(PerftestResult o1, PerftestResult o2) {
        if (o1.name.compareTo(o2.name) != 0) {
            return o1.name.compareTo(o2.name);
        }

        return System.identityHashCode(o1) - System.identityHashCode(o2);
    }
}