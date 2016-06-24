package com.trillia.jpa.container;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.UserRoleAssociation;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by mmathew on 18/06/16.
 */

@XmlRootElement(name = "userRoleAssociationList", namespace = "http://trilia-cloud.com/schema/entity/ut/UserRoleAssociation/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"userRoleAssociationList"})
public class UserRoleAssociationContainer {


    @XmlElement(name = "userRoleAssociation")
    private List<UserRoleAssociation> userRoleAssociationList;

    public List<UserRoleAssociation> getEntityList() {
        return userRoleAssociationList;
    }

    public void setEnityList(List<UserRoleAssociation> userRoleAssociationListList) {
        this.userRoleAssociationList = userRoleAssociationListList;
    }

}
