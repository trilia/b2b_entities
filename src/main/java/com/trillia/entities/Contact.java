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
@Table(name = "trl_contacts", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId"}), @UniqueConstraint(columnNames = {"contactAlias"})})
@Indexed(index = "Contacts")

public class Contact implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id", nullable = false)
    @XmlElement(name = "contact-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "tenant_id", cascade = CascadeType.ALL)
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
