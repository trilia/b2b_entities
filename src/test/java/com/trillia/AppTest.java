package com.trillia;

import com.olp.jpa.common.DataLoader;
import com.trillia.common.BaseSpringAwareTest;
import com.trillia.common.JAXBUtility;
import com.trillia.controller.UserController;
import com.trillia.jpa.container.RoleContainer;
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


   // @org.junit.Test
    @Rollback(false)
    public void loadUsers() throws JAXBException {
        UserContainer userContainer = getModel("user_list.xml", UserContainer.class);
        userController.addUser(userContainer.getEntityList());
    }


   // @org.junit.Test
    @Rollback(false)
    public void loadUserRoleAssociation() throws JAXBException {
        UserRoleAssociationContainer userRoleAssociationContainer = getModel("userroleassociation_list.xml", UserRoleAssociationContainer.class);
        userController.addUserRoleAssociation(userRoleAssociationContainer.getEntityList());
    }


  //  @org.junit.Test
    @Rollback(false)
    public void loadRoles() {
        RoleContainer roleContainer = null;
        try {
            roleContainer = getModel("role_list.xml", RoleContainer.class);
            userController.addRoles(roleContainer.getEntityList());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }



    @org.junit.Test
    @Rollback(false)
    public void testUserRoleAssociation(){

        try
        {
            List<Role> roleList = userController.getRoles("766");
            System.out.println(roleList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }






    public static UserContainer getUser() {
        UserContainer userContainer = new UserContainer();
        List<Users> userList = new ArrayList<>();
        Random random = new Random();

        try {
            //   UserContainer userContainer = new UserContainer();

            for (int i = 0; i < 10; i++) {
                Users users = new Users();
                users.setRevisedById(String.valueOf(random.nextLong()));
                users.setLdapReference(String.valueOf(random.nextGaussian()));
                Subscriber subscriber = new Subscriber();
                subscriber.setId(random.nextLong());
                subscriber.setPartitionCode(String.valueOf(random.nextGaussian()));
                subscriber.setSubscriberEmail("test" + String.valueOf(random.nextInt()) + "@yopmail.com");
                subscriber.setSubscriberPhone(String.valueOf(random.nextLong()));
                subscriber.setSubscriberName("subscriber" + String.valueOf(random.nextInt()));
                users.setUserName("userName" + i);
                users.setUserType("Type" + i);
                users.setCreatedBy("martin");
                users.setTenantId(subscriber);
                users.setTenantId(subscriber);
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
            UserContainer userContainer = (UserContainer) getModel("user_list.xml", UserContainer.class);
            List<Role> roleList = new ArrayList<>();
            for (Users user : userContainer.getEntityList()) {
                Role role = new Role();
                role.setTenantId(user.getTenantId());
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
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return roleContainer;

    }


    private UserRoleAssociationContainer getUserRoleAssociationContainer() throws JAXBException {
        UserRoleAssociationContainer userRoleAssociationContainer = new UserRoleAssociationContainer();
        Random random = new Random();
        UserContainer userContainer = getModel("user_list.xml", UserContainer.class);
        RoleContainer roleContainer = getModel("role_list.xml", RoleContainer.class);
        List<Users> usersList = userContainer.getEntityList();
        List<UserRoleAssociation> userRoleAssociations = new ArrayList<>();
        List<Role> roleList = roleContainer.getEntityList();
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
