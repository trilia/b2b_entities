package com.trillia.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mmathew on 26/05/16.
 */

@Entity
@Table(name = "trl_business_objects",uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId","objectCode"})})
@Indexed(index = "BusinessObject")
public class BusinessObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "object_id", nullable = false)
    @XmlElement(name = "object-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field( analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;


    @XmlElement(name = "object-code")
    @Column(name = "object_code")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO)
    })
    private String objectCode;


    @XmlElement(name = "object-name")
    @Column(name = "object_name")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO)
    })
    private String objectName;


    @XmlElement(name = "module-code")
    @Column(name = "module_code")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO)
    })
    private String moduleCode;

    @XmlElement(name = "privilege-list")
    @Column(name = "privilege_list")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO)
    })
    private List<String> privilegeList;


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

    public List<String> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<String> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
