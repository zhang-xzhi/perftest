package allen.perftest.testcase.findEnum;

public class BizSubTypeCase1 extends AbstractBizSubTypeCase {

    @Override
    protected BizSubTypeEnum getBizSubTypeEnumByCode(String code) {
        return BizSubTypeEnum.getEnumByCode(code);
    }

    @Override
    public String des() {
        return "loop1";
    }
}
