package com.trillia.jpa.entities;

import com.trillia.jpa.fieldbridge.RoleBridge;
import com.trillia.jpa.fieldbridge.SubscriberBridge;
import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mmathew on 27/06/16.
 */

@Entity
@Table(name = "trl_role_privilege_associations", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"})})
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("UserRoleAssociation")
@FullTextFilterDef(name = "filter-role-privilege-association", impl = TenantBasedSearchFilterFactory.class)
@XmlRootElement(name = "RolePrivilegeAssociation", namespace = "http://trilia-cloud.com/schema/entity/ut/RolePrivilegeAssociation/")
@XmlAccessorType(XmlAccessType.FIELD)
public class RolePrivilegeAssociation extends RevisionControl {


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
    @FieldBridge(impl = RoleBridge.class)
    private Role roleId;


    @XmlElement(name = "sub-role-id")
    @ManyToOne
    @JoinColumn(name = "sub_role_id")
    @FieldBridge(impl = RoleBridge.class)
    private Role subRoleId;


    @XmlElement(name = "objectId")
    @ManyToOne
    @JoinColumn(name = "objectId")
    @FieldBridge(impl = RoleBridge.class)
    private BusinessObject objectId;

    @XmlElement(name = "privilege-list")
    @Column(name = "privilege_list")
    private String priviegeList;


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

    public Role getSubRoleId() {
        return subRoleId;
    }

    public void setSubRoleId(Role subRoleId) {
        this.subRoleId = subRoleId;
    }

    public BusinessObject getObjectId() {
        return objectId;
    }

    public void setObjectId(BusinessObject objectId) {
        this.objectId = objectId;
    }

    public String getPriviegeList() {
        return priviegeList;
    }

    public void setPriviegeList(String priviegeList) {
        this.priviegeList = priviegeList;
    }
}
