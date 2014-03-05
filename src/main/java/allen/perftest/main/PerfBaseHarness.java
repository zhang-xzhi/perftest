package allen.perftest.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import allen.perftest.PerfBase;
import allen.perftest.result.PerftestResult;
import allen.perftest.result.PerftestResultAvgComparator;
import allen.perftest.result.PerftestResultNameComparator;
import allen.perftest.testcase.CreateException;
import allen.perftest.testcase.CreateObject;
import allen.perftest.testcase.TimeMeasurementCurrentTimeMillis;
import allen.perftest.testcase.Empty;
import allen.perftest.testcase.NewDate;
import allen.perftest.testcase.TimeMeasurementNanoTime;
import allen.perftest.testcase.bytescopy.BytesCopyFactory;
import allen.perftest.testcase.exception.ExceptionFactory;
import allen.perftest.testcase.list.ListFactory;
import allen.perftest.testcase.reflect.ReflectionFactory;

public class PerfBaseHarness {

    private static class Control {

        final static int    LoopMaxLimit  = 10000000;
        final static double DeltaLimit    = 0.2D;
        final static int    LoopInOneTest = 5;

        int                 curLoop;
        int                 loopStep;

        void step() {
            curLoop += loopStep;
        }

        void reset() {
            curLoop = 20000;
            loopStep = 20000;
        }

        boolean canStep() {
            return curLoop < LoopMaxLimit;
        }
    }

    private static List<PerfBase> init() {
        List<PerfBase> list = new ArrayList<PerfBase>();
        list.add(new Empty());

        list.add(new NewDate());
        list.add(new TimeMeasurementCurrentTimeMillis());
        list.add(new TimeMeasurementNanoTime());

        list.add(new CreateObject());
        list.add(new CreateException());

        list.addAll(new BytesCopyFactory().getPerfBase());
        list.addAll(new ReflectionFactory().getPerfBase());
        list.addAll(new ExceptionFactory().getPerfBase());
        list.addAll(new ListFactory().getPerfBase());

        return list;

    }

    public static void main(String[] args) throws Exception {

        List<PerfBase> list = init();
        List<PerftestResult> resultList = new ArrayList<PerftestResult>();

        Control c = new Control();

        for (PerfBase perfBase : list) {

            c.reset();
            while (c.canStep()) {

                long[] avgs = new long[Control.LoopInOneTest];

                for (int i = 0; i < Control.LoopInOneTest; i++) {
                    perfBase.reset();

                    long start = System.nanoTime();
                    for (int j = 0; j < c.curLoop; j++) {
                        perfBase.run();
                    }
                    long timeDiff = System.nanoTime() - start;
                    avgs[i] = timeDiff / c.curLoop;
                }

                long avg = avg(avgs);

                if (!isInGap(avgs, avg, Control.DeltaLimit)) {
                    c.step();
                    //                    System.out.println("step" + c.curLoop);
                    continue;
                } else {
                    PerftestResult result = new PerftestResult();
                    result.avg = avg;
                    result.des = perfBase.des();
                    result.loop = c.curLoop * Control.LoopInOneTest;
                    result.name = perfBase.name();

                    resultList.add(result);
                    break;
                }
            }
        }
        System.out.println("gapLimit=" + Control.DeltaLimit + " loopInOneTest="
                + Control.LoopInOneTest);
        Collections.sort(resultList, new PerftestResultAvgComparator());
        System.out.println("---------------------");
        for (PerftestResult result : resultList) {
            System.out.println(result);
        }
        System.out.println("---------------------");
        Collections.sort(resultList, new PerftestResultNameComparator());
        for (PerftestResult result : resultList) {
            System.out.println(result);
        }
    }

    public static long sum(long[] a) {
        long t = 0;
        for (long i : a) {
            t += i;
        }
        return t;
    }

    public static long avg(long[] a) {
        return sum(a) / a.length;
    }

    public static boolean isInGap(long[] a, long c, double gap) {
        for (long i : a) {
            double delta = 1.0D * (i - c) / c;
            if (delta < -gap || delta > gap) {
                return false;
            }
        }
        return true;
    }
}
