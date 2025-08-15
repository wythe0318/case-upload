package com.tch.common.enums;

/** 办件来源枚举
 * @author duanjunlong
 * @data 2024/3/21 9:27
 */

public enum DocumentsBase {



    BJBH("45","20"),
    CKSQ("10","20"),//窗口申请
    PCWSSQ("11","21"),//PC网上申请
    WXJYDDSQ("12","22"),//微信及移动申请
    SFQBLSP("13","23");//省发起并联审批

//    CKSQ("10","20"),//窗口申请
//    PCWSSQ("11","21"),//PC网上申请
//    WXJYDDSQ("12","22"),//微信及移动申请
//    SFQBLSP("13","23");//省发起并联审批
//    YJJK("",""),//已建接口
//    FJBSAPPSQ("",""),//福建办事APP申请
//    MZTAPPSQ("",""), //闽政通APP申请
//    ZJXTGXSXSQ("","");//自建系统共享事项办件


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


     DocumentsBase(String key, String value) {
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
        return targetKey; // 不存在对应的 key 值
    }

}
