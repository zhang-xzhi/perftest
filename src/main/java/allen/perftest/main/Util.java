package allen.perftest.main;

public class Util {

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

    public static void gc() {
        for (int i = 0; i < 2; i++) {
            System.gc();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
