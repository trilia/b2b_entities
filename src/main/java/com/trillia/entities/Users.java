package com.trillia.entities;


import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by mmathew on 20/05/16.
 */

@Entity
@Table(name = "trl_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId", "userName"})})
@Indexed(index = "Users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    @XmlElement(name = "user-id")
    private Long id;


    @XmlElement(name = "tenant-id")
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    private Subscriber tenantId;


    @XmlElement(name = "user-name")
    @Column(name = "user_name")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })

    private String userName;


    @XmlElement(name = "user-type")
    @Column(name = "user_type")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String userType;


    @XmlElement(name = "ldap-reference")
    @Column(name = "ldap_reference")
    @Fields({
            @Field,
            @Field(name = "ldapReference-sort", index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    @SortableField(forField = "ldapReference-sort")
    private String ldapReference;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLdapReference() {
        return ldapReference;
    }

    public void setLdapReference(String ldapReference) {
        this.ldapReference = ldapReference;
    }


}



