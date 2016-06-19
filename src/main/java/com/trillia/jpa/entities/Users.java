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

/**
 * Created by mmathew on 20/05/16.
 */

@Entity
@Table(name = "trl_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id", "user_name"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-users-by-tenant", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="Users", namespace="http://trilia-cloud.com/schema/entity/ut/Users/")
@XmlAccessorType(XmlAccessType.FIELD)
//@DiscriminatorValue("Users")
public class Users extends RevisionControl  {




    @XmlElement(name = "tenant-id")
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @Fields({
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @FieldBridge(impl = SubscriberBridge.class)
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
  //  @SortableField(forField = "ldapReference-sort")
    private String ldapReference;



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



