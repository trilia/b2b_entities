package com.trillia.common;

import com.trillia.jpa.container.UserContainer;
import com.trillia.jpa.entities.Users;

import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by mmathew on 11/06/16.
 */
public class JAXBUtility<T> {


    public UserContainer xmlToObject(String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance();


        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        UserContainer unmarshalledObject =
                (UserContainer)unmarshaller.unmarshal(
                        ClassLoader.getSystemResourceAsStream(xml));

        //4. Get the instance of the required JAXB Root Class from the JAXBElement.
       // UserContainer expenseObj = (UserContainer) unmarshalledObject.getValue();
    return unmarshalledObject;



//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        InputStream is1 = loader.getResourceAsStream("users.xml");
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance();
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            return  (T)unmarshaller.unmarshal(is1);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
    }



}
