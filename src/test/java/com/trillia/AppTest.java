package com.trillia;

import com.olp.jpa.common.DataLoader;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.trillia.common.BaseSpringAwareTest;
import com.trillia.common.JAXBUtility;
import com.trillia.controller.UserController;
import com.trillia.jpa.container.RoleContainer;
import com.trillia.jpa.container.SubscriberContainer;
import com.trillia.jpa.container.UserContainer;
import com.trillia.jpa.container.UserRoleAssociationContainer;
import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.Subscriber;
import com.trillia.jpa.entities.UserRoleAssociation;
import com.trillia.jpa.entities.Users;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Unit test for simple App.
 */


@EnableAutoConfiguration
@EntityScan(basePackages = "com.trillia.jpa.entities")
public class AppTest
        extends BaseSpringAwareTest {

    @Autowired
    private UserController userController;


   //  @org.junit.Test
    @Rollback(false)
    public void loadSubscribers() throws JAXBException {
        SubscriberContainer subscriberContainer = getSubscriber();//getModel("subscriber_list.xml", SubscriberContainer.class);
        List<Subscriber> subscriberList = userController.addSubscriber(subscriberContainer.getEntityList());
        subscriberContainer.setEnityList(subscriberList);
         writeModels("src//test//resource//subscriber_list.xml", SubscriberContainer.class, subscriberContainer);
    }


   //  @org.junit.Test
    @Rollback(false)
    public void loadUsers() throws JAXBException {
        UserContainer userContainer = getUser();//getModel("user_list.xml", UserContainer.class);
        List<Users> usersList = userController.addUser(userContainer.getEntityList());
        userContainer.setEnityList(usersList);
        writeModels("src//test//resource//user_list.xml", UserContainer.class, userContainer);
    }

    // @org.junit.Test
    @Rollback(false)
    public void loadRoles() {
        RoleContainer roleContainer = null;
        try {
            roleContainer = getRoles();//getModel("role_list.xml", RoleContainer.class);
            List<Role> roleList = userController.addRoles(roleContainer.getEntityList());
            roleContainer.setEnityList(roleList);
            writeModels("src//test//resource//role_list.xml", RoleContainer.class, roleContainer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @org.junit.Test
    @Rollback(false)
    public void loadUserRoleAssociation() throws JAXBException {
        UserRoleAssociationContainer userRoleAssociationContainer = getUserRoleAssociationContainer();//getModel("userroleassociation_list.xml", UserRoleAssociationContainer.class);
        List<UserRoleAssociation> userRoleAssociationList = userController.addUserRoleAssociation(userRoleAssociationContainer.getEntityList());
        userRoleAssociationContainer.setEnityList(userRoleAssociationList);
        writeModels("src//test//resource//userroleassociation_list.xml", UserRoleAssociationContainer.class, userRoleAssociationContainer);
    }


      //@org.junit.Test
    @Rollback(false)
    public void testUserRoleAssociation() {

        try {
            List<Role> roleList = userController.getRoles("690");
            System.out.println(roleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  UserContainer getUser() throws JAXBException {
        UserContainer userContainer = new UserContainer();
        List<Users> userList = new ArrayList<>();
        Random random = new Random();
       List<Subscriber> subscriberList = userController.geAlltSubcriber();//getModel("subscriber_list.xml", SubscriberContainer.class);
        SubscriberContainer subscriberContainer = new SubscriberContainer();//userController.geAlltSubcriber();//getModel("subscriber_list.xml", SubscriberContainer.class);
        try {
            //   UserContainer userContainer = new UserContainer();
          //  List<Subscriber> subscriberList = subscriberContainer.getEntityList();
            for (int i = 0; i < 10; i++) {
                Users users = new Users();
                users.setRevisedById(String.valueOf(random.nextLong()));
                users.setLdapReference(String.valueOf(random.nextGaussian()));

                users.setUserName("userName" + i);
                users.setUserType("Type" + i);
                users.setCreatedBy("martin");
                users.setTenantId(subscriberList.get(i));

                userList.add(users);
            }
            userContainer.setEnityList(userList);
        } catch (Exception e) {

        }
        return userContainer;
    }


    public RoleContainer getRoles() {

        RoleContainer roleContainer = new RoleContainer();
        Random random = new Random();
        try {
          //  UserContainer userContainer = (UserContainer) getModel("user_list.xml", UserContainer.class);
            List<Subscriber> subscriberList = userController.geAlltSubcriber();
            List<Role> roleList = new ArrayList<>();
            for (Subscriber subscriber : subscriberList) {
                Role role = new Role();
                role.setTenantId(subscriber);
                role.setRevisedById(String.valueOf(random.nextLong()));
                role.setCreatedBy("martin");
                role.setEnabled(true);
                role.setExternalRoleReference(String.valueOf(random.nextGaussian()));
                role.setRoleCode("RoleCode" + random.nextInt());
                role.setRoleName("RoleName" + random.nextInt());
                role.setRoleSource("RoleSource" + random.nextInt());
                role.setObjectVersionNumber("objectVersionNo" + random.nextGaussian());
                roleList.add(role);
            }
            roleContainer.setEnityList(roleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleContainer;

    }


    private UserRoleAssociationContainer getUserRoleAssociationContainer() throws JAXBException {
        UserRoleAssociationContainer userRoleAssociationContainer = new UserRoleAssociationContainer();
        Random random = new Random();
//        UserContainer userContainer = getModel("user_list.xml", UserContainer.class);
//        RoleContainer roleContainer = getModel("role_list.xml", RoleContainer.class);
        List<Users> usersList = userController.getUsers();//userContainer.getEntityList();
        List<UserRoleAssociation> userRoleAssociations = new ArrayList<>();
        List<Role> roleList = userController.getRoles();//roleContainer.getEntityList();
        for (int i = 0; i < usersList.size(); i++) {
            UserRoleAssociation userRoleAssociation = new UserRoleAssociation();
            userRoleAssociation.setTenantId(usersList.get(i).getTenantId());
            userRoleAssociation.setRoleId(roleList.get(i));
            userRoleAssociation.setUserId(usersList.get(i));
            userRoleAssociation.setRevisedById(String.valueOf(random.nextLong()));
            userRoleAssociation.setObjectVersionNumber("objectVersionNo" + random.nextGaussian());
            userRoleAssociation.setEnabled(true);
            userRoleAssociation.setCreatedBy("martin");
            userRoleAssociation.setCreatedDate(new Date());
            userRoleAssociations.add(userRoleAssociation);
        }
        userRoleAssociationContainer.setEnityList(userRoleAssociations);
        return userRoleAssociationContainer;

    }


    private SubscriberContainer getSubscriber() {
        SubscriberContainer subscriberContainer = new SubscriberContainer();
        Random random = new Random();
        List<Subscriber> subscriberList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setSubscriberName("Subscriber:" + random.nextInt());
            subscriber.setSubscriberPhone(Long.toString(random.nextLong()));
            subscriber.setSubscriberEmail("email@mail.com");
            subscriber.setPartitionCode("paritioncode:" + random.nextInt());
            subscriberList.add(subscriber);

        }
        subscriberContainer.setEnityList(subscriberList);
        return subscriberContainer;
    }


    static public <T> T getModel(String xml, Class<T> class1) throws JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance(class1);
        //Marshaller marshallerObj = contextObj.createMarshaller();
        //marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //   ;
        //marshallerObj.marshal(getUser(), new FileOutputStream("user_list.xml"));

        Unmarshaller unmarshaller = contextObj.createUnmarshaller();
        T object = (T) unmarshaller.unmarshal(ClassLoader.getSystemResourceAsStream(xml));
        return object;
    }


    static public <T> void writeModels(String xml, Class<T> class1, T t) {
        try {
            FileOutputStream fos = new FileOutputStream(xml);
            JAXBContext contextObj = JAXBContext.newInstance(class1);
            Marshaller marshallerObj = contextObj.createMarshaller();

            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshallerObj.marshal(t, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
