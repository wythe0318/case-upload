package com.tch.common.enums;

/**
 * @author duanjunlong
 * @data 2024/3/22 15:48
 */

public enum DocumentsResults {

    PZ("准予批准","Y"),
    PZ1("准予许可","Y"),
    BYPZ("不予批准","N"),
    BYPZ1("不予许可","N");




    private String key;
    private String value;


    DocumentsResults(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String checkKeyExists(String targetKey) {
        // 遍历枚举类中的所有枚举值
        for (DocumentsBase base : DocumentsBase.values()) {
            if (base.getKey().equals(targetKey)) {
                return base.getValue(); // 存在对应的 key 值
            }
        }
        return null; // 不存在对应的 key 值
    }
}
