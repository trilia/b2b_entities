package com.trillia.jpa.entities;

import com.trillia.jpa.fieldbridge.SubscriberBridge;
import com.trillia.jpa.fieldbridge.UserBridge;
import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "trl_user_privilege_map", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"})})
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("UserPrivilegeMapping")
@FullTextFilterDef(name="filter-user-privilege-map", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="UserPrivilegeMapping", namespace="http://trilia-cloud.com/schema/entity/ut/UserPrivilegeMapping/")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserPrivilegeMapping extends RevisionControl  {




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


    @XmlElement(name = "user-name")
    @Column(name = "user_name")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String userName;


    @XmlElement(name = "module-code")
    @Column(name = "module_code")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String moduleCode;

    @XmlElement(name = "object-id")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @ManyToOne
    @JoinColumn(name = "object_id")
    private BusinessObject objectId;

    @XmlElement(name = "object-code")
    @Column(name = "object_code")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String objectCode;

    @XmlElement(name = "object-name")
    @Column(name = "object_name")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String objectName;


    @XmlElement(name = "privilege-list")
    @Column(name = "privilege_list")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String privilegeList;


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public BusinessObject getObjectId() {
        return objectId;
    }

    public void setObjectId(BusinessObject objectId) {
        this.objectId = objectId;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(String privilegeList) {
        this.privilegeList = privilegeList;
    }
}
