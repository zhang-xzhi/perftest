package allen.perftest.result;

import java.util.Comparator;

public class PerftestResultNameComparator implements Comparator<PerftestResult> {

    @Override
    public int compare(PerftestResult o1, PerftestResult o2) {
        if (o1.name.compareTo(o2.name) != 0) {
            return o1.name.compareTo(o2.name);
        }

        if (o1.perfTestCaseClass == o2.perfTestCaseClass) {
            if (o1.extraPara != null) {
                for (int i = 0; i < o1.extraPara.length; i++) {
                    Object p1 = o1.extraPara[i];
                    Object p2 = o2.extraPara[i];
                    if (p1 instanceof Comparable) {
                        Comparable c1 = (Comparable) p1;
                        Comparable c2 = (Comparable) p2;
                        if (c1.compareTo(c2) != 0) {
                            return c1.compareTo(c2);
                        }
                    }
                }
            }
        }
        return System.identityHashCode(o1) - System.identityHashCode(o2);
    }
}