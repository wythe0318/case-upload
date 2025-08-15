package com.tch.quartz.task;

import com.tch.system.constants.Constants;
import com.tch.system.domain.TBusisysinfo;
import com.tch.system.domain.TResourceInfo;
import com.tch.system.entity.common.ConvertBaseData;
import com.tch.system.entity.common.Router;
import com.tch.system.mapper.TBusisysinfoMapper;
import com.tch.system.mapper.TResourceInfoMapper;
import com.tch.system.mapper.WsspXmlMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/15 11:07
 */
@Component("auditingSyncTask")
public class AuditingSyncTask {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TResourceInfoMapper tResourceInfoMapper;

    @Resource
    private WsspXmlMapper wsspXmlMapper;


    @Resource
    private TBusisysinfoMapper tBusisysinfoMapper;


    public void syncConvert() {
        try {
            //查询出办件数据 限制为1000条
            List<TBusisysinfo> tBusISysInfos = tBusisysinfoMapper.selectTBusisysinfoByType(Constants.BJXX_TYPE);
//            ArrayList<TBusisysinfo> tBusISysInfoArrayList = new ArrayList<>();
            if (ObjectUtils.isNotEmpty(tBusISysInfos)) {//判断办件信息不能为空
                for (TBusisysinfo tBusiSysInfo : tBusISysInfos) {//查询出重复案件
                    upDataConvertBaseData(tBusiSysInfo);
                    tBusiSysInfo.setTchar4(Constants.OPERATION_LOGO_1);
//                    tBusISysInfoArrayList.add(tBusiSysInfo);
                    tBusisysinfoMapper.updateTBusisysinfo(tBusiSysInfo);
                }
//                if (!tBusISysInfoArrayList.isEmpty()){
//                    //批量修改
//                    tBusisysinfoMapper.updateTBusisysinfoByIdList(tBusISysInfoArrayList);
//                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 按照省厅反馈更新办件数据
     * @param tBusiSysInfo 办件数据
     */
    private void upDataConvertBaseData(TBusisysinfo tBusiSysInfo) {
        TResourceInfo tResourceInfo = tResourceInfoMapper.selectTResourceInfoDataResultRepeat(tBusiSysInfo.getUnid());
        if (ObjectUtils.isNotEmpty(tResourceInfo)) {
            List<String> dataLists = getNextDataId(tResourceInfo.getTchar1());
            System.out.println("进行修改的办件Uuid为:" + dataLists.toString());
//            ArrayList<ConvertBaseData> convertBaseDataArrayList = new ArrayList<>();
            for (String dataList : dataLists) {
                ConvertBaseData convertBaseData = wsspXmlMapper.selectConvertBaseDataUnid(dataList);
                convertBaseData.setResourceInfoType(Constants.RESOURCE_INFO_TYPE_999);
                convertBaseData.setOperationLogo(Constants.OPERATION_LOGO_2);
//                convertBaseDataArrayList.add(convertBaseData);
                wsspXmlMapper.updateConvertBaseData(convertBaseData);
            }
//            if (!convertBaseDataArrayList.isEmpty()){
//                //进行批量修改
//                wsspXmlMapper.updateConvertBaseDataList(convertBaseDataArrayList);
//            }
        }
    }


    /**
     * 根据unId查询出办件信息下的所有过程
     * @param unId 办件id
     * @return 返回办件信息下的所有过程的list(也包括办件信息本身)
     */
    public List<String> getNextDataId(String unId) {
        ArrayList<String> nextDataLists = new ArrayList<>();
        nextDataLists.add(unId);
        Router rData = new Router();
        rData.setDataId(unId);
        Router router = wsspXmlMapper.selectRouter(rData);
        return getPrevLinkData(router.getDataId(), nextDataLists);
    }

    /**
     * 根据unId获取办件信息下所有过程信息
     * @param unId Id
     * @param dataLists 存放办件以及过程和结果ID的集合
     * @return 返回办件信息下的所有过程的list(也包括办件信息本身)
     */
    public List<String> getPrevLinkData(String unId, List<String> dataLists) {
        Router rData = new Router();
        rData.setPrevLinkUNID(unId);
        Router router = wsspXmlMapper.selectRouter(rData);
        if (ObjectUtils.isNotEmpty(router)) {
            dataLists.add(router.getDataId());
            //递归  获取对应办件信息下的所有过程信息
            return getPrevLinkData(router.getDataId(), dataLists);
        } else {
            return dataLists;

        }
    }

}
