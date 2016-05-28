package com.trillia.entities;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "trl_organizations", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId","orgCode"})})
@Indexed(index = "Organization")
public class Organization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organization_id", nullable = false)
    @XmlElement(name = "organization-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
