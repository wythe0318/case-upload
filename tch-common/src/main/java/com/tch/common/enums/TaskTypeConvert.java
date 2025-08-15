//package com.tch.common.enums;
//
///**
// * @author duanjunlong
// * @data 2024/4/16 15:32
// */
//
//public enum TaskTypeConvert {
//
//
//
//    private String key;
//    private String value;
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    TaskTypeConvert(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public static String checkKeyExists(String targetKey) {
//        // 遍历枚举类中的所有枚举值
//        for (AssortConvert base : AssortConvert.values()) {
//            if (base.getKey().equals(targetKey)) {
//                return base.getValue(); // 存在对应的 key 值
//            }
//        }
//        return null; // 不存在对应的 key 值
//    }
//}
