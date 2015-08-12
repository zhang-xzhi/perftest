package allen.perftest.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import allen.perftest.Control;
import allen.perftest.PerfTestCase;
import allen.perftest.result.PerftestResult;
import allen.perftest.result.PerftestResultNameComparator;
import allen.perftest.testcase.CreateException;
import allen.perftest.testcase.CreateObject;
import allen.perftest.testcase.Empty;
import allen.perftest.testcase.bytescopy.BytesCopyFactory;
import allen.perftest.testcase.cache.CacheFactory;
import allen.perftest.testcase.exception.ExceptionFactory;
import allen.perftest.testcase.findEnum.BizSubTypeCase1;
import allen.perftest.testcase.findEnum.BizSubTypeCase2;
import allen.perftest.testcase.findEnum.BizSubTypeCase_Map;
import allen.perftest.testcase.list.ListFactory;
import allen.perftest.testcase.math.MathFactory;
import allen.perftest.testcase.memory.MMFactory;
import allen.perftest.testcase.reflect.ReflectionFactory;
import allen.perftest.testcase.string.StringFactory;
import allen.perftest.testcase.time.TimeFactory;

public class PerfTestHarness {

    private static List<PerfTestCase> init() {

        List<PerfTestCase> list = new ArrayList<PerfTestCase>();

        //        list.add(new CreateException());
        //        list.add(new CreateObject());
        //        list.add(new Empty());
        //        list.addAll(new CacheFactory().getPerfTestCaseList());
        //        list.addAll(new ListFactory().getPerfTestCaseList());
        //        list.addAll(new MathFactory().getPerfTestCaseList());
        //        list.addAll(new MMFactory().getPerfTestCaseList());

        //已经测试出结果的。
        //        list.addAll(new ExceptionFactory().getPerfTestCaseList());
        //        list.addAll(new ReflectionFactory().getPerfTestCaseList());
        //        list.addAll(new StringFactory().getPerfTestCaseList());
        //        list.addAll(new TimeFactory().getPerfTestCaseList());
        //        list.addAll(new BytesCopyFactory().getPerfTestCaseList());

        //测试枚举getEnumByCode。
        //        list.add(new BizSubTypeCase1());
        //        list.add(new BizSubTypeCase2());
        //        list.add(new BizSubTypeCase_Map());
        return list;

    }

    private static void warmup(PerfTestCase testCase, long loop) {
        Control c = testCase.getControl();

        //warm up
        long start = System.nanoTime();
        testCase.beforeRunSuite();
        for (long j = 0; j < loop; j++) {
            testCase.run();
        }
        testCase.afterRunSuite();
        long timeDiff = System.nanoTime() - start;
        //warm up

        System.out.println("[allen] warm up result " + testCase.name() + " "
                + c.getDes() + " timeDiff=" + timeDiff);

        c.adjust(timeDiff, loop);

        System.out.println("[allen] warm up after adjust " + testCase.name()
                + " " + c.getDes());
    }

    public static void main(String[] args) throws Exception {

        List<PerfTestCase> list = init();
        List<PerftestResult> resultList = new ArrayList<PerftestResult>();

        for (PerfTestCase testCase : list) {

            Control c = testCase.getControl();

            //预热1：默认跑10000次，触发JIT。，根据当前avg时间调整下次loop的次数。期望一个suite可以在2s左右。
            //预热2：根据预热1计算的loop次数，重新跑一次，由于代码已经JIT过，理论上，本次run的时候avg会变小，根据当前avg时间调整下次loop的次数。期望一个suite可以在2s左右。

            System.out.println();
            System.out.println("---------WarmupLoop 1---------------------");
            warmup(testCase, c.getWarmupLoop());
            //等待JIT完成。
            Util.pause(1000);

            System.out.println();
            System.out.println("---------WarmupLoop 2---------------------");
            warmup(testCase, c.getCurLoop());
            //等待JIT完成。
            Util.pause(1000);

            while (true) {
                System.out.println();
                System.out
                        .println("-----------------------------------------------------");
                System.out.println("[allen]  running " + testCase.name() + " "
                        + c.getDes());

                double[] avgs = new double[c.getSuiteCount()];

                for (int i = 0; i < c.getSuiteCount(); i++) {

                    if (c.isNeedGcBeforeRun()) {
                        Util.gc();
                    }

                    testCase.beforeRunSuite();
                    long start = System.nanoTime();
                    for (int j = 0; j < c.getCurLoop(); j++) {
                        testCase.run();
                    }
                    long timeDiff = System.nanoTime() - start;
                    testCase.afterRunSuite();

                    avgs[i] = 1.0D * timeDiff / c.getCurLoop();
                }

                PerftestResult result = new PerftestResult();

                result.des = testCase.des();
                result.name = testCase.name();
                result.perfTestCaseClass = testCase.getClass();
                result.extraPara = testCase.extraPara();
                result.control = c;
                result.results = avgs;

                result.avg = Util.avg(avgs);
                result.standardDeviation = Util.standardDeviation(avgs);

                if (c.isSatisfiedForResult(result)) {
                    resultList.add(result);
                    System.out.println("[allen] done " + testCase.name() + " "
                            + c.getDes());
                    break;
                }

                c.adjustForResult(result);
            }
        }

        System.out
                .println("-----------------------------------------------------");
        System.out.println();

        Collections.sort(resultList, new PerftestResultNameComparator());
        for (PerftestResult result : resultList) {
            System.out.println();
            System.out
                    .println("-----------------------------------------------------");
            System.out.println(result);
        }
    }

}
