package com.tch.system.mapper;

import com.tch.system.dto.converts.CovertFormInfoDTO;
import com.tch.system.entity.common.*;
import com.tch.system.entity.convert2xml.*;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/3 16:03
 */

public interface WsspXmlMapper {

    public List<ConvertBaseData> selectConvertBaseData(ConvertBaseData data);


    public List<ConvertBaseData> selectByApplyFrom();

    public ConvertBaseData selectConvertBaseDataUnid(String unId);

    public List<ConvertBaseData> selectConvertBaseDataByType(String type);

    public int updateConvertBaseData(ConvertBaseData convertBaseData);


    public int updateConvertBaseDataList(List<ConvertBaseData> convertBaseDataList);



    public int insertAttr(Attr attr);

    public List<Attr> selectAttrByDataId(String dataId);


    public int insertRouter(Router router);

    public Router selectRouter(Router router);

    public Router selectByRouterDataId (String dataId);



    public int insertApasInfo(ConvertEntityApasInfo convertApasInfo);


    public ConvertEntityApasInfo selectByApasInfobusISysInfoUuid(String busISysInfoUuid);



    public int insertCloudForm(CloudForm cloudForm);

    public CloudForm selectCloudFormByUnId(String busISysInfoUuid);

    public int insertConvertEntity(ConvertBaseData convertBaseData);


    public int insertDocument(CovertDocument covertDocument);

    public List<CovertDocument> selectDocumentByDataId(String dataId);


    public int insertExpress(Express express);

    public Express selectExpressByUuid(String busISysInfoUuid);


    public int insertExtend(Extend extend);

    public Extend selectExtendByUuid(String busISysInfoUuid);

    public int insertFormInfo(CovertFormInfo covertFormInfo);

    public List<CovertFormInfoDTO> selectFormInfoByDataId(String busISysInfoUuid);


    public int insertItem(CovertItem covertItem);

    public List<CovertItem> selectItemByDataId(String dataId);

    public int insertOperator(Operator operator);

    public Operator selectOperatorByUNID(String busISysInfoUuid);

    public int insertProposer(Proposer proposer);

    public Proposer selectProposerByUuId(String busISysInfoUuid);

    public int insertPerson(Person person);

    public Person selectPersonUNID(String dataId);

    public int insertUnit(Unit unit);

    public Unit selectUnitByDataId(String dataId);

    public int insertSms(Sms sms);

    public Sms selectSmsByDUuid(String busISysInfoUuid);


    List<ConvertBaseData> selectByApplyFromIsData();
}
