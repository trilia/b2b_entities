package com.trillia.entities;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "trl_role_privileges_map", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId"}), @UniqueConstraint(columnNames = {"objectCode"})})
@Indexed(index = "RolePrivilegeMappings")
public class UserPrivilegeMapping {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user-priv-id", nullable = false)
    @XmlElement(name = "user-priv-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;


    @XmlElement(name = "user-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
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
    @JoinColumn(name = "object_id", referencedColumnName = "object_id")
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

    public List<String> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<String> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
