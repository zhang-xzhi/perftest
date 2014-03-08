package allen.perftest.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import allen.perftest.Control;
import allen.perftest.PerfTestCase;
import allen.perftest.result.PerftestResult;
import allen.perftest.result.PerftestResultAvgComparator;
import allen.perftest.result.PerftestResultNameComparator;
import allen.perftest.testcase.CreateException;
import allen.perftest.testcase.CreateObject;
import allen.perftest.testcase.Empty;
import allen.perftest.testcase.bytescopy.BytesCopyFactory;
import allen.perftest.testcase.cache.CacheFactory;
import allen.perftest.testcase.exception.ExceptionFactory;
import allen.perftest.testcase.list.ListFactory;
import allen.perftest.testcase.math.MathFactory;
import allen.perftest.testcase.memory.MMFactory;
import allen.perftest.testcase.reflect.ReflectionFactory;
import allen.perftest.testcase.string.StringFactory;
import allen.perftest.testcase.time.TimeFactory;
import allen.perftest.testcase.time.Time_NewDate;
import allen.perftest.testcase.time.Time_CurrentTimeMillis;
import allen.perftest.testcase.time.Time_NanoTime;

public class PerfTestHarness {

    private static List<PerfTestCase> init() {
        List<PerfTestCase> list = new ArrayList<PerfTestCase>();

        //        list.add(new Empty());
        //        list.add(new CreateObject());
        //        list.add(new CreateException());
        //
        //        list.addAll(new MathFactory().getPerfTestCaseList());
        //        list.addAll(new CacheFactory().getPerfTestCaseList());
        //        list.addAll(new ListFactory().getPerfTestCaseList());

        list.addAll(new ExceptionFactory().getPerfTestCaseList());
        list.addAll(new ReflectionFactory().getPerfTestCaseList());
        list.addAll(new BytesCopyFactory().getPerfTestCaseList());
        list.addAll(new TimeFactory().getPerfTestCaseList());
        list.addAll(new StringFactory().getPerfTestCaseList());
        list.addAll(new MMFactory().getPerfTestCaseList());

        return list;

    }

    public static void main(String[] args) throws Exception {

        List<PerfTestCase> list = init();
        List<PerftestResult> resultList = new ArrayList<PerftestResult>();

        for (PerfTestCase testCase : list) {
            Control c = testCase.getControl();

            while (c.canStep()) {
                c.step();

                System.out.println("running " + testCase.name() + " "
                        + c.getDes());

                long[] avgs = new long[c.getSuiteCount()];

                for (int i = 0; i < c.getSuiteCount(); i++) {

                    testCase.beforeRunSuite();

                    long start = System.nanoTime();
                    for (int j = 0; j < c.getCurLoop(); j++) {
                        testCase.run();
                    }
                    long timeDiff = System.nanoTime() - start;

                    avgs[i] = timeDiff / c.getCurLoop();

                    testCase.afterRunSuite();
                }

                long avg = avg(avgs);

                if (isInDelta(avgs, avg, c.getConsumingTimeDeltaLimit())) {

                    PerftestResult result = new PerftestResult();
                    result.avg = avg;
                    result.des = testCase.des();
                    result.name = testCase.name();
                    result.perfTestCaseClass = testCase.getClass();
                    result.extraPara = testCase.extraPara();
                    result.control = c;

                    resultList.add(result);
                    System.out.println("done " + testCase.name() + " "
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
