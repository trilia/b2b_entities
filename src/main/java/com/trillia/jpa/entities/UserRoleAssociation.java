package com.trillia.jpa.entities;

import com.trillia.jpa.fieldbridge.RoleBridge;
import com.trillia.jpa.fieldbridge.SubscriberBridge;
import com.trillia.jpa.fieldbridge.UserBridge;
import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.annotations.Cascade;
import org.hibernate.search.annotations.*;
import org.hibernate.search.bridge.StringBridge;

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
@Table(name = "trl_user_role_associations", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"})})
@Indexed(index = "SetupDataIndex")
@NamedQueries({
        @NamedQuery(name="UserRoleAssociation.findByUser", query="SELECT t from UserRoleAssociation t  WHERE t.userId.id = :id")
})
//@DiscriminatorValue("UserRoleAssociation")
@FullTextFilterDef(name="filter-user-role-association", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="UserRoleAssociation", namespace="http://trilia-cloud.com/schema/entity/ut/UserRoleAssociation/")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRoleAssociation extends RevisionControl  {




    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "user-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "user_id")
    @FieldBridge(impl = UserBridge.class)
    private Users userId;


    @XmlElement(name = "role-id")
    @ManyToOne
    @JoinColumn(name = "role_id")
    @FieldBridge(impl = RoleBridge.class)
    private Role roleId;

    @XmlElement(name = "enabled-flag")
    @Column(name = "enabled_flag")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private boolean isEnabled;

    @XmlElement(name = "status")
    @Column(name = "status")
    private String status;


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
