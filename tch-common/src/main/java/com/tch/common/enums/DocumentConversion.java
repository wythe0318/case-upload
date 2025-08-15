package com.tch.common.enums;

/**单据类型转换
 * @author duanjunlong
 * @data 2024/3/21 18:56
 */

public enum DocumentConversion {

    SLTZS("1","04"),//受理通知书
    SJTZS("2","02"),//收件通知书
    TJTZS("3","09"),//退件通知书
    BSLTZS("4","03"),//不受理通知书
    BJTZS("5","05"),//补件通知书
    BJIETZS("6","14");//办结通知书


    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    DocumentConversion(String key, String value) {
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
