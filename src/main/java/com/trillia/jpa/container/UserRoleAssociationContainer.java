package com.trillia.jpa.container;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.UserRoleAssociation;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by mmathew on 18/06/16.
 */

@XmlRootElement(name = "userRoleList", namespace = "http://trilia-cloud.com/schema/entity/ut/UserRoleAssociation/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"userRoleAssociationListList"})
public class UserRoleAssociationContainer {


    @XmlElement(name = "role")
    private List<UserRoleAssociation> userRoleAssociationListList;

    public List<UserRoleAssociation> getEntityList() {
        return userRoleAssociationListList;
    }

    public void setEnityList(List<UserRoleAssociation> userRoleAssociationListList) {
        this.userRoleAssociationListList = userRoleAssociationListList;
    }

}
