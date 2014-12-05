package allen.perftest.testcase.findEnum;

public class BizSubTypeCase2 extends AbstractBizSubTypeCase {

    @Override
    protected BizSubTypeEnum getBizSubTypeEnumByCode(String code) {
        return BizSubTypeEnum.getEnumByCode2(code);
    }

    @Override
    public String des() {
        return "loop2";
    }

}
