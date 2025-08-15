package com.tch.common.enums;

/**
 * @author duanjunlong
 * @data 2024/3/25 18:37
 */

public enum TypeConversion {
    TYPE_10("10", "210"),
    TYPE_20("20", "220"),
    TYPE_21("21", "220"),
    TYPE_22("22", "220"),
    TYPE_23("23", "220"),
    TYPE_24("24", "220"),
    TYPE_30("30", "230");

    private final String originalType;
    private final String convertedType;

    TypeConversion(String originalType, String convertedType) {
        this.originalType = originalType;
        this.convertedType = convertedType;
    }

    public String getOriginalType() {
        return originalType;
    }

    public String getConvertedType() {
        return convertedType;
    }


    public static String checkKeyExists(String targetKey) {
        // 遍历枚举类中的所有枚举值
        for (TypeConversion base : TypeConversion.values()) {
            if (base.getOriginalType().equals(targetKey)) {
                return base.getConvertedType(); // 存在对应的 key 值
            }
        }
        return targetKey; // 不存在对应的 key 值
    }


}

