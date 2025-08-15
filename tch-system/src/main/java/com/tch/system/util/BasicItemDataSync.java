package com.tch.system.util;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ：Wythe
 * @description：基础事项同步
 * @date ：2024/03/26 15:49
 */
public class BasicItemDataSync {
    /**
     * 请求ID参数(唯一参数,使用UUID生成即可)
     **/
    public static final String AEP_NONCE = "x-aep-nonce";
    /**
     * appkey参数(应用appkey)
     */
    public static final String AEP_APPKEY = "x-aep-appkey";
    /**
     * 时间戳参数
     */
    public static final String AEP_TIMESTAMP = "x-aep-timestamp";
    /**
     * 签名参数
     **/
    public static final String AEP_SIGNATURE = "x-aep-signature";
    /**
     * 是否加密(默认false)
     */
    public static final String AEP_ENCRYPTION = "x-aep-encryption";

    /**
     * 网关地址
     */
	final static String AEP_GATE_URL = "http://112.48.134.93:8088/aep/";
   // final static String AEP_GATE_URL = "http://10.192.15.54:8099/aep/";
    /**
     * APP_KEY Value
     */
    final static String appKeyValue = "1694160018850668544";
    /**
     * APP_SECRET Value
     */
    final static String appSecretValue = "29B449D3DF44432F8B3287621A0ABBAF";


    public static String post(String url, JSONObject jsonObject) {
        try {
            String uuid = UUID.randomUUID().toString();
            String timestamp = String.valueOf(System.currentTimeMillis());
            Map<String, Object> postcs = new HashMap<>();
            postcs.put("page", "1");
            postcs.put("rows", "1000");
            postcs.put("orgCode", jsonObject.get("orgCode"));
            System.out.println("//////////////////////////////////////////////////////////////");
            System.out.println(jsonObject.get("orgCode"));
            String result2 = HttpRequest.post(AEP_GATE_URL.concat(url))
                    .header(AEP_NONCE, uuid)
                    .header(AEP_APPKEY, appKeyValue)
                    .header(AEP_TIMESTAMP, timestamp)
                    //.header(AEP_AEP_ENCRYPT_SM3,String.valueOf(true))
                    .header(AEP_SIGNATURE, hmac256Encode(getBody(uuid, timestamp)))
                    .form(postcs)
                    .timeout(20000)//超时，毫秒
                    // 可以使用抓包工具，查看是否调用请求参数对的
                    //.setHttpProxy("127.0.0.1", 8888)
                    .execute().body();
            System.out.println(result2);
            System.out.println("**************************************************");
            return result2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getBody(String uuid, String time) {
        Map<String, String> objectMap = new HashMap<>();
        objectMap.put(AEP_APPKEY, appKeyValue);
        objectMap.put(AEP_NONCE, uuid);
        objectMap.put(AEP_TIMESTAMP, time);
        return MapUtil.sortJoin(objectMap, "&", "=", true);
    }


    public static String hmac256Encode(String data) {
        HMac mac = new HMac(HmacAlgorithm.HmacSHA256, appSecretValue.getBytes(StandardCharsets.UTF_8));
        //字符拼接
        //x-aep-appkey=1610890418759884800&x-aep-nonce=2f4cc542-a3dc-495e-9e18-8763bbdfc3e3&x-aep-timestamp=1678361340997
        //加密结果
        //4f6263e193556481158d5e64f408ee2ae51df5f0f13a305211d76dafad7cd509
        return HexUtil.encodeHexStr(mac.digest(data));
    }

    public static String get(String url, String params) {
        try {
            String uuid = UUID.randomUUID().toString();
            String timestamp = String.valueOf(System.currentTimeMillis());
            String result2 = HttpRequest.get(AEP_GATE_URL.concat(url).concat(params))
                    .header(AEP_NONCE, uuid)
                    .header(AEP_APPKEY, appKeyValue)
                    .header(AEP_TIMESTAMP, timestamp)
                    //.header(AEP_AEP_ENCRYPT_SM3,String.valueOf(true))
                    .header(AEP_SIGNATURE, hmac256Encode(getBody(uuid, timestamp)))
                    //.form(postcs)
                    .timeout(20000)//超时，毫秒
                    // 可以使用抓包工具，查看是否调用请求参数对的
                    //.setHttpProxy("127.0.0.1", 8888)
                    .execute().body();
            System.out.println(result2);
            return result2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
