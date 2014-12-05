package allen.perftest.testcase.findEnum;

import allen.perftest.AbstractPerfTestCase;

abstract public class AbstractBizSubTypeCase extends AbstractPerfTestCase {
    protected static BizSubTypeEnum bizSubTypeEnum;
    private String[]                codes;

    @Override
    public void beforeRunSuite() {
        BizSubTypeEnum[] values = BizSubTypeEnum.values();
        codes = new String[values.length];
        for (int i = 0; i < codes.length; i++) {
            codes[i] = values[i].getCode();
        }
    }

    @Override
    public void afterRunSuite() {
        System.out.println("afterRunSuite " + bizSubTypeEnum);
    }

    @Override
    public void run() {
        for (String s : codes)
            bizSubTypeEnum = getBizSubTypeEnumByCode(s);

    }

    abstract protected BizSubTypeEnum getBizSubTypeEnumByCode(String code);

}
