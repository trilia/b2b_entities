package com.trillia.jpa.container;

import com.olp.jpa.common.EntityContainerTemplate;
import com.trillia.jpa.entities.Users;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by mmathew on 11/06/16.
 */
@XmlRootElement(name="userList", namespace="http://trilia-cloud.com/schema/entity/ut/Users/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"userList"})

public class UserContainer implements EntityContainerTemplate<Users, Long> {

    @XmlElement(name="user")
    private List<Users> userList ;

    @Override
    public List<Users> getEntityList() {
        return userList;
    }

    public void setEnityList(List<Users> userList)
    {
        this.userList = userList;
    }
}
