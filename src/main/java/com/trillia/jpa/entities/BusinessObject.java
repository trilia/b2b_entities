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
import java.util.List;

/**
 * Created by mmathew on 26/05/16.
 */

@Entity
@Table(name = "trl_business_objects", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id", "object_code"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-business-object-by-tenant", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("BusinessObject")
@XmlRootElement(name="BusinessObject", namespace="http://trilia-cloud.com/schema/entity/ut/BusinessObject/")
@XmlAccessorType(XmlAccessType.FIELD)
public class BusinessObject extends RevisionControl  {


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "object-code")
    @Column(name = "object_code")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO)
    })
    private String objectCode;


    @XmlElement(name = "object-name")
    @Column(name = "object_name")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO)
    })
    private String objectName;


    @XmlElement(name = "module-code")
    @Column(name = "module_code")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO)
    })
    private String moduleCode;

    @XmlElement(name = "privilege-list")
    @Column(name = "privilege_list")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO)
    })
    private String privilegeList;


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
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

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(String privilegeList) {
        this.privilegeList = privilegeList;
    }
}
