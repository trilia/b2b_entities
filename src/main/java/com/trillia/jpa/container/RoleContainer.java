package com.trillia.jpa.container;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.Users;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by mmathew on 18/06/16.
 */
@XmlRootElement(name = "roleList", namespace = "http://trilia-cloud.com/schema/entity/ut/Role/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"roleList"})
public class RoleContainer {


    @XmlElement(name = "role")
    private List<Role> roleList;

    public List<Role> getEntityList() {
        return roleList;
    }

    public void setEnityList(List<Role> roleList) {
        this.roleList = roleList;
    }


}
