package allen.perftest.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import allen.perftest.Control;
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
import allen.perftest.testcase.cache.CacheFactory;
import allen.perftest.testcase.exception.ExceptionFactory;
import allen.perftest.testcase.list.ListFactory;
import allen.perftest.testcase.math.MathFactory;
import allen.perftest.testcase.reflect.ReflectionFactory;

public class PerfBaseHarness {

    private static List<PerfBase> init() {
        List<PerfBase> list = new ArrayList<PerfBase>();
        list.add(new Empty());

        list.add(new NewDate());
        list.add(new TimeMeasurementCurrentTimeMillis());
        list.add(new TimeMeasurementNanoTime());

        list.add(new CreateObject());
        list.add(new CreateException());

        list.addAll(new MathFactory().getPerfBase());
        list.addAll(new CacheFactory().getPerfBase());
        list.addAll(new BytesCopyFactory().getPerfBase());
        list.addAll(new ReflectionFactory().getPerfBase());
        list.addAll(new ExceptionFactory().getPerfBase());
        list.addAll(new ListFactory().getPerfBase());

        return list;

    }

    public static void main(String[] args) throws Exception {

        List<PerfBase> list = init();
        List<PerftestResult> resultList = new ArrayList<PerftestResult>();

        for (PerfBase perfBase : list) {
            Control c = perfBase.getControl();

            while (c.canStep()) {
                c.step();

                System.out.println("running " + perfBase.name() + " "
                        + c.getDes());

                long[] avgs = new long[c.getTestSuiteCount()];

                for (int i = 0; i < c.getTestSuiteCount(); i++) {

                    perfBase.beforeRunSuite();

                    long start = System.nanoTime();
                    for (int j = 0; j < c.getCurLoop(); j++) {
                        perfBase.run();
                    }
                    long timeDiff = System.nanoTime() - start;

                    avgs[i] = timeDiff / c.getCurLoop();

                    perfBase.afterRunSuite();
                }

                long avg = avg(avgs);

                if (isInDelta(avgs, avg, c.getConsumingTimeDeltaLimit())) {

                    PerftestResult result = new PerftestResult();
                    result.avg = avg;
                    result.des = perfBase.des();
                    result.name = perfBase.name();
                    result.perfTestCaseClass = perfBase.getClass();
                    result.extraPara = perfBase.extraPara();
                    result.control = c;

                    resultList.add(result);
                    System.out.println("done " + perfBase.name() + " "
                            + c.getDes());
                    break;
                }

            }
        }

        Collections.sort(resultList, new PerftestResultAvgComparator());
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

    public static boolean isInDelta(long[] a, long c, double gap) {
        for (long i : a) {
            double delta = 1.0D * (i - c) / c;
            if (delta < -gap || delta > gap) {
                return false;
            }
        }
        return true;
    }
}
