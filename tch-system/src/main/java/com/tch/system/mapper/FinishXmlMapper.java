package com.tch.system.mapper;


import com.tch.system.entity.finish2xml.FinishAttr;
import com.tch.system.entity.finish2xml.FinishApasInfo;
import com.tch.system.entity.finish2xml.ResultCaseEntity;
import com.tch.system.entity.link2xml.*;
import com.tch.system.entity.xml2bean.FinishLicense;
import com.tch.system.entity.xml2bean.FinishResultAttr;
import com.tch.system.entity.xml2bean.FinishSMS;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/3 18:05
 */

public interface FinishXmlMapper {

    // 插入 FinishApasInfo
    int insertApasInfo(FinishApasInfo apasInfo);

    public FinishApasInfo selectApasInfoByUnId(String busISysInfoUuid);

    // 插入 FinishAttr
    int insertAttr(FinishAttr finishAttr);

    public List<FinishAttr> selectFinishAttrByDataId(String dataId);

    // 插入 ResultCaseEntity
    int insertFinishData(ResultCaseEntity resultCaseEntity);

    // 插入 FinishLicense
    int insertFinishLicense(FinishLicense finishLicense);

    public List<FinishLicense> selectFinishLicenseByUnId(String busISysInfoUuid);

    // 插入 FinishResultAttr
    int insertFinishResultAttr(FinishResultAttr finishResultAttr);

    public List<FinishResultAttr> selectFinishResultAttrByUnId(String busISysInfoUuid);

    // 插入 FinishSMS
    int insertFinishSMS(FinishSMS finishSMS);

    public FinishSMS selectFinishSMSByUnId(String busISysInfoUuid);

    // 插入 SpecialEnd
    int insertSpecialEnd(SpecialEnd specialEnd);

    public SpecialEnd selectSpecialEndByDataId(String dataId);

    // 插入 SpecialStart
    int insertSpecialStart(SpecialStart specialStart);

    public SpecialStart selectSpecialStartByDataId(String dataId);

    // 插入 SuppMat
    int insertSuppMat(SuppMat suppMat);

    public SuppMat selectSuppMatByDataId(String dataId);

    // 插入 SuppMatStart
    int insertSuppMatStart(SuppMatStart suppMatStart);

    public SuppMatStart selectSuppMatStartByDataId(String dataId);

    // 插入 SuppMatStartAttr
    int insertSuppMatStartAttr(SuppMatStartAttr suppMatStartAttr);

    public List<SuppMatStartAttr> selectSuppMatStartAttrByDataId(String dataId);
}
