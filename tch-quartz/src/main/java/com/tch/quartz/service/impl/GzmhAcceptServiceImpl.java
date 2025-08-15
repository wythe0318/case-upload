package com.tch.quartz.service.impl;

import com.tch.common.core.domain.AjaxResult;
import com.tch.quartz.service.GzmhAcceptService;
import com.tch.system.dto.converts.*;
import com.tch.system.entity.common.*;
import com.tch.system.entity.convert2xml.*;
import com.tch.system.entity.finish2xml.FinishApasInfo;
import com.tch.system.entity.finish2xml.FinishAttr;
import com.tch.system.entity.next2xml.NextConvertApasInfo;
import com.tch.system.entity.next2xml.NextNode;
import com.tch.system.entity.xml2bean.FinishLicense;
import com.tch.system.entity.xml2bean.FinishResultAttr;
import com.tch.system.mapper.FinishXmlMapper;
import com.tch.system.mapper.NextXmlMapper;
import com.tch.system.mapper.WsspXmlMapper;
import com.tch.system.vo.converts.ConvertDataVO;
import com.tch.system.vo.converts.FinishDataVO;
import com.tch.system.vo.converts.NextDataVO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/5/20 10:16
 */
@Service
public class GzmhAcceptServiceImpl implements GzmhAcceptService {

    @Autowired
    private WsspXmlMapper wsspXmlMapper;

    @Autowired
    private NextXmlMapper nextXmlMapper;

    @Autowired
    private FinishXmlMapper finishXmlMapper;

    @Override
    public AjaxResult transmissionData() {


        try {
            ArrayList<ConvertDTO> convertDTOS = new ArrayList<>();
            Date date = new Date();
            //获取出办件信息800条
            List<ConvertBaseData> convertBaseDataList = wsspXmlMapper.selectByApplyFrom();
            for (ConvertBaseData convertBaseData : convertBaseDataList) {
                ConvertDTO convertDTO = new ConvertDTO();
                WsspDataDTO wsspDataDTO = new WsspDataDTO();
                String wsspUnid = convertBaseData.getUnid();
                //封装出办件信息
                Router router = wsspXmlMapper.selectByRouterDataId(wsspUnid);
                wsspDataDTO.setRouter(router);
                wsspDataDTO.setConvertBaseData(convertBaseData);
                ConvertEntityApasInfo convertEntityApasInfo = wsspXmlMapper.selectByApasInfobusISysInfoUuid(wsspUnid);
                Express express = wsspXmlMapper.selectExpressByUuid(wsspUnid);
                Extend extend = wsspXmlMapper.selectExtendByUuid(wsspUnid);
                Sms sms = wsspXmlMapper.selectSmsByDUuid(wsspUnid);
                Unit unit = wsspXmlMapper.selectUnitByDataId(wsspUnid);
                CloudForm cloudForm = wsspXmlMapper.selectCloudFormByUnId(wsspUnid);
                Operator operator = wsspXmlMapper.selectOperatorByUNID(wsspUnid);
                Proposer proposer = wsspXmlMapper.selectProposerByUuId(wsspUnid);
                Person person = wsspXmlMapper.selectPersonUNID(wsspUnid);
                //把对应属性赋值到convertDataVO里
                ConvertDataVO convertDataVO = new ConvertDataVO();
                ConvertDataVO expressConvertDataVO = copyProperties(express, convertDataVO);
                ConvertDataVO extendConvertDataVO = copyProperties(extend, expressConvertDataVO);
                ConvertDataVO smsConvertDataVO = copyProperties(sms, extendConvertDataVO);
                ConvertDataVO unitConvertDataVO = copyProperties(unit, smsConvertDataVO);
                ConvertDataVO cloudFormConvertDataVO = copyProperties(cloudForm, unitConvertDataVO);
                ConvertDataVO operatorConvertDataVO = copyProperties(operator, cloudFormConvertDataVO);
                ConvertDataVO proposerConvertDataVO = copyProperties(proposer, operatorConvertDataVO);
                ConvertDataVO personConvertDataVO = copyProperties(person, proposerConvertDataVO);
                BeanUtils.copyProperties(convertEntityApasInfo,personConvertDataVO);
                personConvertDataVO.setUnId(wsspUnid);

                List<CovertFormInfoDTO> covertFormInfoDTOS = unIdQueryFormInfoList(wsspUnid);
                if (!covertFormInfoDTOS.isEmpty()){
                    wsspDataDTO.setCovertFormInfo(covertFormInfoDTOS);
                }
                List<Attr> wsspAttr = wsspXmlMapper.selectAttrByDataId(wsspUnid);
                if (!wsspAttr.isEmpty()){
                    wsspDataDTO.setConverAttrs(wsspAttr);
                }
                wsspDataDTO.setConvertData(personConvertDataVO);

                convertDTO.setWsspDataDTO(wsspDataDTO);
                //封装出过程信息
                ArrayList<NextDataDTO> nextDataDTOS = new ArrayList<>();
                List<String> nextDataIds = getNextDataId(wsspUnid);
                List<String> nextDataList = nextDataIds.subList(0, nextDataIds.size() - 1);
                for (String nextDataId : nextDataList) {
                    NextDataDTO nextDataDTO = new NextDataDTO();
                    ConvertBaseData nextBaseData = wsspXmlMapper.selectConvertBaseDataUnid(nextDataId);
                    nextDataDTO.setConvertBaseData(nextBaseData);
                    Router nextRouter = wsspXmlMapper.selectByRouterDataId(nextDataId);
                    nextDataDTO.setRouter(nextRouter);
                    NextConvertApasInfo nextConvertApasInfo = nextXmlMapper.selectNextApasInfoByUuId(nextDataId);
                    NextDataVO nextDataVO = new NextDataVO();
                    BeanUtils.copyProperties(nextConvertApasInfo,nextDataVO);
                    NextNode nextNode = nextXmlMapper.selectNextNodeByUuId(nextDataId);
                    BeanUtils.copyProperties(nextNode,nextDataVO);
                    nextDataVO.setUnId(wsspUnid);
                    nextDataVO.setNextId(nextDataId);
                    List<CovertDocument> covertDocuments = wsspXmlMapper.selectDocumentByDataId(nextDataId);
                    List<com.tch.system.entity.next2xml.Attr> nextAttrs = nextXmlMapper.selectNextAttrByDataId(nextDataId);
                    if (!nextAttrs.isEmpty()){
                        nextDataDTO.setAttrs(nextAttrs);
                    }

                    if (!covertDocuments.isEmpty()){
                        nextDataDTO.setDocuments(covertDocuments);
                    }
                    nextDataDTO.setNextData(nextDataVO);
                    nextDataDTOS.add(nextDataDTO);
                }
                convertDTO.setNextDataDTOS(nextDataDTOS);

                //封装出结果信息
                String finishId = nextDataIds.get(nextDataIds.size() - 1);
                FinishDataDTO finishDataDTO = new FinishDataDTO();
                ConvertBaseData finishBaseData = wsspXmlMapper.selectConvertBaseDataUnid(finishId);
                Router finishRouter = wsspXmlMapper.selectByRouterDataId(finishId);
                finishDataDTO.setConvertBaseData(finishBaseData);
                finishDataDTO.setRouter(finishRouter);
                FinishDataVO finishDataVO = new FinishDataVO();
                FinishApasInfo finishApasInfo = finishXmlMapper.selectApasInfoByUnId(finishId);
                BeanUtils.copyProperties(finishApasInfo,finishDataVO);
                finishDataDTO.setFinishData(finishDataVO);

                List<CovertFormInfoDTO> finishCovertFormInfoDTO= unIdQueryFormInfoList(finishId);
                finishDataDTO.setFinishFormInfo(finishCovertFormInfoDTO);
                List<FinishAttr> finishAttrs = finishXmlMapper.selectFinishAttrByDataId(finishId);
                if (!finishAttrs.isEmpty()){
                    finishDataDTO.setFinishAttrs(finishAttrs);
                }
                List<FinishLicense> finishLicenses = finishXmlMapper.selectFinishLicenseByUnId(finishId);
                if (!finishLicenses.isEmpty()) {
                    finishDataDTO.setFinishLicenses(finishLicenses);
                }

                List<CovertDocument> finishCovertDocuments = wsspXmlMapper.selectDocumentByDataId(finishId);
                if (!finishCovertDocuments.isEmpty()){
                    finishDataDTO.setDocuments(finishCovertDocuments);
                }
                List<FinishResultAttr> finishResultAttrs = finishXmlMapper.selectFinishResultAttrByUnId(finishId);

                if (!finishResultAttrs.isEmpty()){
                    finishDataDTO.setFinishResultAttrs(finishResultAttrs);
                }

                convertDTO.setFinishDataDTO(finishDataDTO);

                //修改更新标志
                convertBaseData.setTransferLogo(date);
                wsspXmlMapper.updateConvertBaseData(convertBaseData);
                convertDTOS.add(convertDTO);
            }

            return AjaxResult.success(convertDTOS);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    private List<CovertFormInfoDTO> unIdQueryFormInfoList(String unId) {
        List<CovertFormInfoDTO> covertFormInfos = wsspXmlMapper.selectFormInfoByDataId(unId);
        if (covertFormInfos.size() > 0) {
            for (CovertFormInfoDTO covertFormInfo : covertFormInfos) {
                //存放表单信息
                List<CovertItem> covertItems = wsspXmlMapper.selectItemByDataId(covertFormInfo.getFormInfoId());
                covertFormInfo.setCovertItems(covertItems);
            }
        }
        return covertFormInfos;
    }


    private ConvertDataVO copyProperties(Object object,ConvertDataVO vo){
        if (ObjectUtils.isNotEmpty(object)){
            BeanUtils.copyProperties(object,vo);
            return vo;
        }
       return  vo;
    }

    /**
     * 根据unId查询出办件信息下的所有过程
     * @param unId 办件id
     * @return 返回办件信息下的所有过程的list(也包括办件信息本身)
     */
    public List<String> getNextDataId(String unId) {
        ArrayList<String> nextDataLists = new ArrayList<>();
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
