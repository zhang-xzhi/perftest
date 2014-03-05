package allen.perftest.result;

import java.util.Comparator;

public class PerftestResultAvgComparator implements Comparator<PerftestResult> {

    @Override
    public int compare(PerftestResult o1, PerftestResult o2) {
        if (o1.avg < o2.avg) {
            return -1;
        }
        if (o1.avg > o2.avg) {
            return 1;
        }
        return System.identityHashCode(o1) - System.identityHashCode(o2);
    }
}