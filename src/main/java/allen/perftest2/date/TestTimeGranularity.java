package allen.perftest2.date;

import org.junit.Test;

/**
 * Test for System.nanoTime() and System.currentTimeMillis() 's Granularity.
 * */
public class TestTimeGranularity {

    @Test
    public void testNanoTime() {

        int sampleLen = 10000;

        long[] sample = new long[sampleLen];
        for (int i = 0; i < sample.length; i++) {
            sample[i] = System.nanoTime();
        }

        double cnt = 0;
        double total = 0;
        for (int i = 1; i < sample.length; i++) {
            if (sample[i] - sample[i - 1] != 0) {
                cnt++;
                total = total + (sample[i] - sample[i - 1]);
            }
        }

        System.out.println();
        System.out.println("testNanoTime");
        System.out.println("sampleLen = " + sampleLen);
        System.out.println("cnt = " + cnt);
        System.out.println("avgNanoTimeGranularity = " + total / cnt);
    }

    @Test
    public void testTimeMillis() {

        int sampleLen = 1000000;

        long[] sample = new long[sampleLen];
        for (int i = 0; i < sample.length; i++) {
            sample[i] = System.currentTimeMillis();
        }

        double cnt = 0;
        double total = 0;
        for (int i = 1; i < sample.length; i++) {
            if (sample[i] - sample[i - 1] != 0) {
                cnt++;
                total = total + (sample[i] - sample[i - 1]);
            }
        }

        System.out.println();
        System.out.println("testTimeMillis");
        System.out.println("sampleLen = " + sampleLen);
        System.out.println("cnt = " + cnt);
        System.out.println("avgTimeMillisGranularity = " + total / cnt);
    }
}
