package com.trillia.jpa.entities;

import com.trillia.jpa.fieldbridge.SubscriberBridge;
import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by mmathew on 27/05/16.
 */

@Entity
@Table(name = "trl_role_privileges_map", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"})})
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("RolePrivilegeMapping")
@FullTextFilterDef(name="filter-role-privilege-map", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="RolePrivilegeMapping", namespace="http://trilia-cloud.com/schema/entity/ut/RolePrivilegeMapping/")
@XmlAccessorType(XmlAccessType.FIELD)
public class RolePrivilegeMapping extends RevisionControl   {




    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;

    @XmlElement(name = "role-id")
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

    @XmlElement(name = "sub-role-id")
    @Column(name = "sub_role_id")
    private long subRoleId;

    @XmlElement(name = "object-id")
    @ManyToOne
    @JoinColumn(name = "object_id")
    private BusinessObject objectId;

    @XmlElement(name = "privilege-list")
    @Column(name = "privilege_list")
    private String privilegeList;


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public BusinessObject getObjectId() {
        return objectId;
    }

    public void setObjectId(BusinessObject objectId) {
        this.objectId = objectId;
    }


    public long getSubRoleId() {
        return subRoleId;
    }

    public void setSubRoleId(long subRoleId) {
        this.subRoleId = subRoleId;
    }


    public String getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(String privilegeList) {
        this.privilegeList = privilegeList;
    }
}
