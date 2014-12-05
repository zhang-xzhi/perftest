package allen.perftest.testcase.findEnum;

public class BizSubTypeCase_Map extends AbstractBizSubTypeCase {

    @Override
    protected BizSubTypeEnum getBizSubTypeEnumByCode(String code) {
        return BizSubTypeEnum.getEnumByCodeByMap(code);
    }

    @Override
    public String des() {
        return "map";
    }
}
