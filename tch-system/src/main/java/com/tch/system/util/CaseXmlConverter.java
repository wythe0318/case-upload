package com.tch.system.util;

import com.tch.common.utils.uuid.IdUtils;
import com.tch.system.constants.Constants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 实体类与xml转换工具类
 */
public class CaseXmlConverter {
    // 实体类转换为 XML
    public static String convertToXml(Object entity) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(entity.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(entity, stringWriter);
            return stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Object parseXml(String xmlContent,Object object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlContent);
            return  jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成对应的uuid
    public static String getUuid() {
        return Constants.FromAreaCode + "-" + Constants.TYSHXYDM + "-" + IdUtils.getSpecialLenId(20);
    }


}
