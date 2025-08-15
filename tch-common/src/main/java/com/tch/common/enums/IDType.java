package com.tch.common.enums;

/**
 * @author duanjunlong
 * @data 2024/3/26 13:15
 */

public enum IDType {
    RESIDENT_ID("SF", "居民身份证"),
    PASSPORT("HZ", "护照"),
    MILITARY_OFFICER_ID("JG", "军官证"),
    SOLDIER_ID("SB", "士兵证"),
    MAINLAND_TRAVEL_PERMIT_FOR_HK_MO("GATX", "港澳居民来往内地通行证"),
    MAINLAND_TRAVEL_PERMIT_FOR_TW("TWTX", "台湾居民来往大陆通行证"),
    OTHER("QT", "其他");

    private final String typeName;
    private final String abbreviation;

    IDType(String typeName, String abbreviation) {
        this.typeName = typeName;
        this.abbreviation = abbreviation;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static String checkKeyExists(String targetKey) {
        // 遍历枚举类中的所有枚举值
        for (IDType base : IDType.values()) {
            if (base.getTypeName().equals(targetKey)) {
                return base.abbreviation; // 存在对应的 key 值
            }
        }
        return null; // 不存在对应的 key 值
    }
}

