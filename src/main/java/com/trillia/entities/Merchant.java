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
@Table(name = "trl_merchants", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId"}), @UniqueConstraint(columnNames = {"merchantShortName"})})
@Indexed(index = "Merchant")

public class Merchant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    @XmlElement(name = "role-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;


    @XmlElement(name = "merchant-short-name")
    @Column(name = "merchant_short_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String merchantShortName;


    @XmlElement(name = "legal-name")
    @Column(name = "legal_name")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    })
    private String legalName;


    @XmlElement(name = "entity-type")
    @Column(name = "entity_type")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    })
    private String entityType;

    @XmlElement(name = "admin-email")
    @Column(name = "admin_email")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String admin_email;


    @XmlElement(name = "phone")
    @Column(name = "phone")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String phone;


    @XmlElement(name = "address")
    @Column(name = "address")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String address;


    @XmlElement(name = "country")
    @Column(name = "country")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    })

    private String country;


    @XmlElement(name = "state")
    @Column(name = "state")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String state;


    @XmlElement(name = "zip-code")
    @Column(name = "zip-code")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })

    private String zipCode;

    @XmlElement(name = "status")
    @Column(name = "status")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String status;


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

    public String getMerchantShortName() {
        return merchantShortName;
    }

    public void setMerchantShortName(String merchantShortName) {
        this.merchantShortName = merchantShortName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
