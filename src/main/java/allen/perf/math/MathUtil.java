package allen.perf.math;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MathUtil {

    public static double avg(double[] arr) {
        DescriptiveStatistics stat = new DescriptiveStatistics(arr);
        return stat.getMean();
    }

    public static double standardDeviation(double[] arr) {
        DescriptiveStatistics stat = new DescriptiveStatistics(arr);
        return stat.getStandardDeviation();
    }
}
