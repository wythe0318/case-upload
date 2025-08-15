package com.tch.system.constants;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 16:11
 */
public class Constants {
    public static final String FromAreaCode = "SGA";//来源系统代码
    public static final String FromAreaName = "厦门公安政务服务平台";//来源系统名称
    public static final String ToAreaCode = "RES";//接收系统代码
    public static final String ToAreaName = "审批资源共享平台";//接收系统名称
    public static final String TargetSystem = "RES";//审批资源共享平台
    public static final String DECLARE_TYPE_PERSONAL = "0"; //申报类型 个人业务
    public static final String DECLARE_TYPE_CORPORATION = "1"; //申报类型 法人业务
    public static final String PROCESSING_INFORMATION = "10";//办件信息 代码
    public static final String TYSHXYDM = "1135020000413900XC";///厦门市公安局统一社会信用代码
    public static final String PROCESS_INFORMATION = "20";//过程信息代码
    public static final String TIMING_PAUSE = "21";//计时暂停代码
    public static final String SUPPLEMENT_INFORMATION = "22";//补件信息
    public static final String TIMING_RECOVERY = "23";//计时恢复代码
    public static final String RESULT_INFORMATION = "30";//结果信息

    public static final String RP = "RP-";//补推消息标准  加在uuid最前面


    /**
     * ---------------------------------------------- 事项类型-----------------------------------------------------------
     **/
    public final static String XK = "01";//行政许可
    public final static String GG = "20";//公共服务
    public final static String CJ = "09";//行政戴决
    public final static String QR = "07";//行政确认
    public final static String JL = "08";//行政奖励
    public final static String AP = "05";//行政给付
    public final static String NS = "10";//内部审批
    public final static String QT = "10";//其他行政权力
/**---------------------------------------------- 事项类型-----------------------------------------------------------**/

    /**
     * ---------------------------------------------------------------业务数据类型-------------------------------------------
     **/
    public static final String BJXX_TYPE = "210";//办件信息
    public static final String GCXX_TYPE = "220";//过程信息
    public static final String JGXX_TYPE = "230";//过程信息

    public static final String RESOURCE_INFO_TYPE_999 = "999";
    public static final String RESOURCE_INFO_TYPE_99 = "99";

    public static final String OPERATION_LOGO_1 = "1";//1 代表省厅通过审核
    public static final String OPERATION_LOGO_2 = "2";//2 代表重复件

    /**
     * -------------------------------------操作状态------------------------------
     **/
    public static final String OPERATION_TYPE_INSERT = "I"; //新增
    public static final String XSD_DEFAULT_TYPE_1 = "1"; //xsd类型
    public static final String VERSION_DEFAULT_TYPE_2 = "2";//版本类型

    public static final String SYNCSTATE = "0"; //同步状态
}
