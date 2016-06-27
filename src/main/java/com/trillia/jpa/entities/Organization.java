package com.trillia.jpa.entities;

import com.trillia.jpa.fieldbridge.SubscriberBridge;
import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

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
@Table(name = "trl_organizations", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id","org_code"})})
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("Organization")
@FullTextFilterDef(name="filter-organization", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="Organization", namespace="http://trilia-cloud.com/schema/entity/ut/Organization/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization extends RevisionControl  {




    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "org-code")
    @Column(name = "org_code")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String orgCode;


    @XmlElement(name = "org-name")
    @Column(name = "org_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })

    private String orgName;


    @XmlElement(name = "parent-org-id")
    @Column(name = "parent_org_id")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private long parentOrgId;


    @XmlElement(name = "org-type")
    @Column(name = "org_type")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String orgType;


    @XmlElement(name = "location-id")
    @Column(name = "location_id")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private long locationId;


    @XmlElement(name = "contact-id")
    @Column(name = "contact_id")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private long contactId;


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
}
