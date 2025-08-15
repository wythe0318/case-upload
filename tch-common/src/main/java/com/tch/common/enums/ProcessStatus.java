package com.tch.common.enums;

/**办件环节转换
 * @author duanjunlong
 * @data 2024/3/28 11:48
 */

public enum ProcessStatus {

    RECEIVED("1", "收件"),
    ACCEPTED("2", "受理"),
    REVIEWED("3", "审核"),
    COMPLETED("4", "办结"),
    PAID("5", "缴费"),
    CERTIFICATE_ISSUED("6", "发证（文）"),
    SUPPLEMENTARY_INFORMATION_RECEIVED("9", "受理（补充受理信息）");

    private final String key;
    private final String chineseValue;

    ProcessStatus(String key, String chineseValue) {
        this.key = key;
        this.chineseValue = chineseValue;
    }

    public String getKey() {
        return key;
    }

    public String getChineseValue() {
        return chineseValue;
    }

    public static String checkKeyExists(String targetKey) {
        // 遍历枚举类中的所有枚举值
        for (ProcessStatus base : ProcessStatus.values()) {
            if (base.getKey().equals(targetKey)) {
                return base.chineseValue; // 存在对应的 key 值
            }
        }
        return ""; // 不存在对应的 key 值
    }
}

