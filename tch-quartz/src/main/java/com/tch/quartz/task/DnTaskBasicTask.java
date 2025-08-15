package com.tch.quartz.task;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tch.system.domain.DnTaskBasic;
import com.tch.system.mapper.DnTaskBasicMapper;
import com.tch.system.util.BasicItemDataSync;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/16 15:55
 */
@Component("dnTaskBasicTask")
public class DnTaskBasicTask {

    @Resource
    private DnTaskBasicMapper basicMapper;


    public void startToSync() throws InterruptedException {
        String orgCode = "11350200K19049184T,TE350212004173494J,TE350213751615866D,TE350212004173494H,11350200K19050468W,TE350211K19048886J,TE350211K19048878A,11350000B36962973L,TE350206K19049188E,TE350206K19049184A,TE350212004173494F,11350200K190503296,11350200004173494J,TE350213751615866G,TE350203004155341A,TE350213751615866C,TE350205K19050253E,TE350212004173494E,TE350203004155341J,TE350203004155341N,11350200K19050249J,TE350203004155341C,TE350212004173494G,TE350203004155341B,TE350205K19050250B,TE350213751615866F,TE350206K19049185B,TE350211K19048881D,TE350205K19050252D,TE350203004155341M,11350200K19048878N,TE350211K19048882E,TE350203004155341E,1135020000413900XC,TE350211999900001Q,TE361000123456789M,TE350211K19048880C,TE350211K19048883F,TE350211K19048885H,TE350213751615866B,TE350211K19048884G,TE350203004155341D,TE350203004155341L,TE361024006067322X,TE350206K19049186C,TE350212004173494C,11350200004155341D,TE350212004173494A,TE350212004173494D,TE350203004155341G,TE350212004173494B,TE350206K19049189F,TE350203004155341I,TE350203004155341H,11350200751615866G,TE350205K19050251C,TE350205K19050249A,TE350213751615866A,TE350213751615866J,TE350203004155341F,TE350206K19049187D,TE350213751615866E,TE350203004155341K";

        //String orgCode = "11350200K19049184T,TE350212004173494J";
        String[] values = orgCode.split(",");
        Date date =new Date();
        JSONObject json = new JSONObject();
        // 批量传输的数据列表
        List<DnTaskBasic> basicList = new ArrayList<>();
        for (String value1 : values) {
            json.put("orgCode", value1);
            String post = BasicItemDataSync.post("sxgl/getItemListByPage", json);
            JSONObject mainData = JSON.parseObject(post);
            JSONObject dataObject = mainData.getJSONObject("data");
            JSONObject nestedDataObject = JSON.parseObject(dataObject.getString("data"));
            JSONArray pageListArray = nestedDataObject.getJSONArray("pageList");
            List<JSONObject> pageList = pageListArray.toJavaList(JSONObject.class);
            for (JSONObject pageListItem : pageList) {
                // 处理每个页面数据，创建各个对象并添加到批量插入列表
                DnTaskBasic basic = createBasicObject(pageListItem, date);
                if(basic!=null){
                    basicList.add(basic);
                }
            }
            //延时2秒进行下一次请求
            Thread.sleep(500);
        }
    }

    // 创建DnTaskBasic对象
    public DnTaskBasic createBasicObject(JSONObject pageListItem, Date date) {

        JSONObject columnsObject = pageListItem.getJSONObject("columns");
        String taskcode = columnsObject.getString("TASKCODE");
        if(StrUtil.isNotEmpty(taskcode)&&StrUtil.isNotEmpty(columnsObject.getString("ITEM_ID"))){
            DnTaskBasic oldTaskBasic = basicMapper.getByRowGuId(columnsObject.getString("ITEM_ID"));
            DnTaskBasic basic = new DnTaskBasic();
            // 设置basic的各个属性
            basic.setTaskCode(taskcode);
            basic.setServiceId(columnsObject.getString("ID"));
            basic.setRegionCode(columnsObject.getString("REGION_CODE"));
            basic.setCode(columnsObject.getString("CODE"));
            basic.setTaskName(columnsObject.getString("NAME"));
            basic.setTaskVersion(columnsObject.getLong("VERSION"));
            basic.setDeptCode(columnsObject.getString("ORG_CODE"));
            String taskhandleitem = columnsObject.getString("TASKHANDLEITEM");
            basic.setTaskHandleItem(taskhandleitem);
            basic.setCreateTime(date);
            basic.setUpdateTime(date);
            String service_object = columnsObject.getString("SERVICE_OBJECT");
            if (StrUtil.isEmpty(service_object)) {
                basic.setServerType("1");
            } else {
                basic.setServerType(columnsObject.getString("SERVICE_OBJECT"));
            }
            String catalogcode = columnsObject.getString("CATALOGCODE");
            if (StrUtil.isEmpty(catalogcode)) {
                basic.setCatalogCode("1");
            } else {
                basic.setCatalogCode(columnsObject.getString("CATALOGCODE"));
            }
            basic.setAnticipateDay(columnsObject.getLong("LAW_TIME"));
            basic.setPromiseType(columnsObject.getString("AGREE_TIME"));
            basic.setPromiseExplain(columnsObject.getString("PROCESSING_TIME_LIMIT"));
            basic.setDeptName(columnsObject.getString("ORG_NAME"));
            basic.setRowGuid(columnsObject.getString("ITEM_ID"));
            basic.setAssort(columnsObject.getString("ASSORT"));
            String is_charge = columnsObject.getString("IS_CHARGE");
            String region_code = columnsObject.getString("REGION_CODE");
            if (StrUtil.isEmpty(region_code)) {
                basic.setCjdw("1");
                basic.setGxdw("1");
            } else {
                basic.setCjdw(region_code);
                basic.setGxdw(region_code);
            }
            if (StrUtil.isEmpty(is_charge)) {
                basic.setIsFee("0");
            } else {
                basic.setIsFee(columnsObject.getString("IS_CHARGE"));
            }
            basic.setPowerSource(columnsObject.getString("POWER_SOURCE"));
            basic.setTaskType(columnsObject.getString("TYPE"));
            String authLevel = columnsObject.getString("AUTH_LEVEL");
            if (StrUtil.isEmpty(authLevel)) {
                basic.setUseLevel("1");
            } else {
                basic.setUseLevel(authLevel);
            }
            basic.setTaskState("1");
            /// TODO: 2023/9/5 以下字段先设默认值
            basic.setTransactTime("1");
            basic.setDeptType("1");
            basic.setAnticipateType("1");
            basic.setProjectType("1");
            basic.setIsSingleLogin("1");
            basic.setAppIsSingleLogin("1");
            basic.setLimitSceneNum(1l);
            basic.setSuperviseWay("1");
            basic.setLinkWay("1");
            //法律依据
            String params = "?type=legalbasis&itemId=" + columnsObject.getString("ITEM_ID");
            String s1 = BasicItemDataSync.get("sxgl/getItemInfoByItemID", params);
            JSONObject legal = JSON.parseObject(s1);
            JSONObject LegalObject = legal.getJSONObject("data");
            JSONObject LegalDataObject = JSON.parseObject(LegalObject.getString("data"));
            JSONArray LegalArray = LegalDataObject.getJSONArray("ItemInfo");
            if (LegalArray.size() > 0) {
                List<JSONObject> LegalList = LegalArray.toJavaList(JSONObject.class);
                for (JSONObject jsonObject : LegalList) {
                    String content = jsonObject.getString("CONTENT");
                    if (StrUtil.isEmpty(content)) {
                        basic.setByLaw("1");
                    } else {
                        basic.setByLaw(jsonObject.getString("CONTENT"));
                    }

                }
            }
            basic.setByLaw("1");
            if (oldTaskBasic==null){
                basic.setId(Long.valueOf(IdUtil.getSnowflakeNextIdStr()));
                System.out.println("insert数据："+basic.toString());
                basicMapper.insertDnTaskBasic(basic);
            }else{
                System.out.println("update数据："+basic.toString());
                basic.setId(oldTaskBasic.getId());
                basicMapper.updateDnTaskBasic(basic);
            }
            return basic;
        }
        return null;
    }
}

