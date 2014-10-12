package allen.perf.math;

public class MathUtil {

    public static double avg(double[] arr) {
        double sum = 0;
        for (double d : arr) {
            sum += d;
        }
        return sum / arr.length;
    }

    public static double standardDeviation(double[] arr) {
        double avg = avg(arr);
        double sum = 0;
        for (double d : arr) {
            sum = sum + (d - avg) * (d - avg);
        }
        return Math.sqrt(sum / arr.length);
    }
}
