package allen.perftest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import allen.perftest.result.PerftestResult;
import allen.perftest.result.PerftestResultAvgComparator;
import allen.perftest.result.PerftestResultNameComparator;
import allen.perftest.testcase.CreateException;
import allen.perftest.testcase.CreateObject;
import allen.perftest.testcase.TimeMeasurementCurrentTimeMillis;
import allen.perftest.testcase.Empty;
import allen.perftest.testcase.NewDate;
import allen.perftest.testcase.SystemArrayCopyFactory;
import allen.perftest.testcase.TimeMeasurementNanoTime;
import allen.perftest.testcase.exception.ExceptionOnlyCreateException;
import allen.perftest.testcase.exception.ExceptionThrowAndCatch;
import allen.perftest.testcase.exception.ExceptionWithTryCatch;
import allen.perftest.testcase.list.ListAddFactory;
import allen.perftest.testcase.reflect.ReflectionField;
import allen.perftest.testcase.reflect.ReflectionFieldInvoke;
import allen.perftest.testcase.reflect.ReflectionMethod;
import allen.perftest.testcase.reflect.ReflectionMethodInvoke;

public class PerfBaseHarness {

    private static class Control {

        final static int    loopMax       = 10000000;
        final static double gapLimit      = 0.2D;
        final static int    loopInOneTest = 5;

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
            return curLoop < loopMax;
        }
    }

    private static List<PerfBase> init() {
        List<PerfBase> list = new ArrayList<PerfBase>();
        list.add(new Empty());
        list.addAll(new SystemArrayCopyFactory().getPerfBase());
        list.add(new NewDate());
        list.add(new TimeMeasurementCurrentTimeMillis());
        list.add(new TimeMeasurementNanoTime());

        list.add(new CreateObject());
        list.add(new CreateException());

        list.add(new ReflectionField());
        list.add(new ReflectionFieldInvoke());
        list.add(new ReflectionMethod());
        list.add(new ReflectionMethodInvoke());
        list.add(new ExceptionThrowAndCatch());
        list.add(new ExceptionWithTryCatch());
        list.add(new ExceptionOnlyCreateException());

        list.addAll(new ListAddFactory().getPerfBase());

        return list;

    }

    public static void main(String[] args) throws Exception {

        List<PerfBase> list = init();
        List<PerftestResult> resultList = new ArrayList<PerftestResult>();

        Control c = new Control();

        for (PerfBase perfBase : list) {

            c.reset();
            while (c.canStep()) {

                long[] avgs = new long[Control.loopInOneTest];

                for (int i = 0; i < Control.loopInOneTest; i++) {
                    perfBase.reset();

                    long start = System.nanoTime();
                    for (int j = 0; j < c.curLoop; j++) {
                        perfBase.run();
                    }
                    long timeDiff = System.nanoTime() - start;
                    avgs[i] = timeDiff / c.curLoop;
                }

                long avg = avg(avgs);

                if (!isInGap(avgs, avg, Control.gapLimit)) {
                    c.step();
                    //                    System.out.println("step" + c.curLoop);
                    continue;
                } else {
                    PerftestResult result = new PerftestResult();
                    result.avg = avg;
                    result.des = perfBase.des();
                    result.loop = c.curLoop * Control.loopInOneTest;
                    result.name = perfBase.name();

                    resultList.add(result);
                    break;
                }
            }
        }
        System.out.println("gapLimit=" + Control.gapLimit + " loopInOneTest="
                + Control.loopInOneTest);
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
