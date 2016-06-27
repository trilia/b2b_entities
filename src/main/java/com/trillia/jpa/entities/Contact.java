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
@Table(name = "trl_contacts", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"}), @UniqueConstraint(columnNames = {"contact_alias"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-contact-by-tenant", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("Contact")
@XmlRootElement(name="Contact", namespace="http://trilia-cloud.com/schema/entity/ut/Contact/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact extends RevisionControl  implements Serializable {




    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "contact-alias")
    @Column(name = "contact_alias")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String contactAlias;


    @XmlElement(name = "contact-type")
    @Column(name = "contact_type")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String contactType;


    @XmlElement(name = "contact")
    @Column(name = "contact")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String contact;


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getContactAlias() {
        return contactAlias;
    }

    public void setContactAlias(String contactAlias) {
        this.contactAlias = contactAlias;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
