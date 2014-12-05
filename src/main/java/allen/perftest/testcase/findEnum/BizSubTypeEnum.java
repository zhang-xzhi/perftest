package allen.perftest.testcase.findEnum;

import java.util.HashMap;

public enum BizSubTypeEnum {

    SUB_TYPE_1("1"),

    SUB_TYPE_2("2"),

    SUB_TYPE_3("3"),

    SUB_TYPE_4("4"),

    SUB_TYPE_5("5"),

    SUB_TYPE_6("6"),

    SUB_TYPE_7("7"),

    SUB_TYPE_8("8"),

    SUB_TYPE_9("9"),

    SUB_TYPE_10("10"),

    SUB_TYPE_11("11"),

    SUB_TYPE_12("12"),

    SUB_TYPE_13("13"),

    SUB_TYPE_14("14"),

    SUB_TYPE_15("15"),

    SUB_TYPE_16("16"),

    SUB_TYPE_17("17"),

    SUB_TYPE_18("18"),

    SUB_TYPE_19("19"),

    SUB_TYPE_20("20"),

    SUB_TYPE_21("21"),

    SUB_TYPE_22("22"),

    SUB_TYPE_23("23"),

    SUB_TYPE_24("24"),

    SUB_TYPE_25("25"),

    SUB_TYPE_26("26"),

    SUB_TYPE_27("27"),

    SUB_TYPE_28("28"),

    SUB_TYPE_29("29"),

    SUB_TYPE_30("30"),

    SUB_TYPE_31("31"),

    SUB_TYPE_32("32"),

    SUB_TYPE_33("33"),

    SUB_TYPE_34("34"),

    SUB_TYPE_39("39"),

    SUB_TYPE_40("40"),

    SUB_TYPE_41("41"),

    SUB_TYPE_42("42"),

    SUB_TYPE_43("43"),

    SUB_TYPE_44("44"),

    SUB_TYPE_46("46"),

    SUB_TYPE_47("47"),

    SUB_TYPE_48("48"),

    SUB_TYPE_49("49"),

    SUB_TYPE_50("50"),

    SUB_TYPE_51("51"),

    SUB_TYPE_52("52"),

    SUB_TYPE_53("53"),

    SUB_TYPE_54("54"),

    SUB_TYPE_55("55"),

    SUB_TYPE_56("56"),

    SUB_TYPE_57("57"),

    SUB_TYPE_58("58"),

    SUB_TYPE_59("59"),

    SUB_TYPE_60("60"),

    SUB_TYPE_61("61"),

    SUB_TYPE_62("62"),

    SUB_TYPE_63("63"),

    SUB_TYPE_64("64"),

    SUB_TYPE_65("65"),

    SUB_TYPE_66("66"),

    SUB_TYPE_67("67"),

    SUB_TYPE_68("68"),

    SUB_TYPE_69("69"),

    SUB_TYPE_70("70"),

    SUB_TYPE_71("71"),

    SUB_TYPE_72("72"),

    SUB_TYPE_80("80"),

    SUB_TYPE_81("81"),

    SUB_TYPE_82("82"),

    SUB_TYPE_83("83"),

    SUB_TYPE_84("84"),

    SUB_TYPE_85("85"),

    SUB_TYPE_86("86"),

    SUB_TYPE_100("100"),

    SUB_TYPE_201("201"),

    SUB_TYPE_202("202"),

    SUB_TYPE_203("203"),

    SUB_TYPE_204("204"),

    SUB_TYPE_205("205"),

    SUB_TYPE_206("206"),

    SUB_TYPE_207("207"),

    SUB_TYPE_208("208"),

    SUB_TYPE_209("209"),

    SUB_TYPE_210("210"),

    SUB_TYPE_211("211"),

    SUB_TYPE_212("212"),

    SUB_TYPE_301("301"),

    SUB_TYPE_401("401"),

    SUB_TYPE_402("402"),

    SUB_TYPE_403("403"),

    SUB_TYPE_404("404"),

    SUB_TYPE_405("405"),

    SUB_TYPE_406("406"),

    SUB_TYPE_407("407"),

    SUB_TYPE_408("408"),

    SUB_TYPE_4081("4081"),

    SUB_TYPE_4082("4082"),

    SUB_TYPE_4083("4083"),

    SUB_TYPE_409("409"),

    SUB_TYPE_410("410"),

    SUB_TYPE_411("411"),

    SUB_TYPE_420("420"),

    SUB_TYPE_421("421"),

    SUB_TYPE_422("422"),

    SUB_TYPE_423("423"),

    SUB_TYPE_424("424"),

    SUB_TYPE_425("425"),

    SUB_TYPE_501("501"),

    SUB_TYPE_502("502"),

    SUB_TYPE_601("601"),

    SUB_TYPE_602("602"),

    SUB_TYPE_701("701"),

    SUB_TYPE_901("901"),

    SUB_TYPE_902("902"),

    SUB_TYPE_903("903"),

    SUB_TYPE_904("904"),

    SUB_TYPE_905("905"),

    SUB_TYPE_960("960"),

    SUB_TYPE_1000("1000"),

    SUB_TYPE_1100("1100"),

    SUB_TYPE_1101("1101"),

    SUB_TYPE_1102("1102"),

    SUB_TYPE_1103("1103"),

    SUB_TYPE_1104("1104"),

    SUB_TYPE_1105("1105"),

    SUB_TYPE_1106("1106"),

    SUB_TYPE_1107("1107"),

    SUB_TYPE_1108("1108"),

    SUB_TYPE_1111("1111"),

    SUB_TYPE_1130("1130"),

    SUB_TYPE_1201("1201"),

    SUB_TYPE_1202("1202"),

    SUB_TYPE_1203("1203"),

    SUB_TYPE_1205("1205"),

    SUB_TYPE_1207("1207"),

    SUB_TYPE_1208("1208"),

    SUB_TYPE_1230("1230"),

    SUB_TYPE_1301("1301"),

    SUB_TYPE_1401("1401"),

    SUB_TYPE_1402("1402"),

    SUB_TYPE_1501("1501"),

    SUB_TYPE_1801("1801"),

    SUB_TYPE_1802("1802"),

    SUB_TYPE_2201("2201"),

    SUB_TYPE_2202("2202"),

    SUB_TYPE_2203("2203"),

    SUB_TYPE_3000("3000"),

    SUB_TYPE_3001("3001"),

    SUB_TYPE_4000("4000"),

    SUB_TYPE_5000("5000"),

    SUB_TYPE_6001("6001"),

    SUB_TYPE_6002("6002"),

    SUB_TYPE_8001("8001"),

    SUB_TYPE_8002("8002"),

    SUB_TYPE_8003("8003"),

    SUB_TYPE_8004("8004"),

    SUB_TYPE_8005("8005"),

    SUB_TYPE_8006("8006"),

    SUB_TYPE_8007("8007"),

    SUB_TYPE_8008("8008"),

    SUB_TYPE_8010("8010"),

    SUB_TYPE_8101("8101"),

    SUB_TYPE_8102("8102"),

    SUB_TYPE_8105("8105"),

    SUB_TYPE_8106("8106"),

    SUB_TYPE_9501("9501"),

    SUB_TYPE_9502("9502"),

    ;

    private final String code;

    public String getCode() {
        return code;
    }

    private BizSubTypeEnum(String code) {
        this.code = code;

    }

    public static BizSubTypeEnum getEnumByCode(String code) {
        // 循环遍历比对
        for (BizSubTypeEnum each : values()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        // 无效的code
        return null;
    }

    public static BizSubTypeEnum getEnumByCode2(String code) {
        BizSubTypeEnum[] values = values();
        // 循环遍历比对
        for (BizSubTypeEnum each : values) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        // 无效的code
        return null;
    }

    static HashMap<String, BizSubTypeEnum> cache;
    static {
        cache = new HashMap<String, BizSubTypeEnum>();
        for (BizSubTypeEnum each : values()) {
            cache.put(each.code, each);
        }
    }

    public static BizSubTypeEnum getEnumByCodeByMap(String code) {
        return cache.get(code);
    }

}
