package com.trillia.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by mmathew on 27/05/16.
 */

@Entity
@Table(name = "trl_role_privileges_map", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId"})})
@Indexed(index = "RolePrivilegeMappings")
public class RolePrivilegeMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_priv_id", nullable = false)
    @XmlElement(name = "role-priv-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;

    @XmlElement(name = "role-id")
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role roleId;

    @XmlElement(name = "sub-role-id")
    @Column(name = "sub_role_id")
    private long subRoleId;

    @XmlElement(name = "object-id")
    @Column(name = "object_id")
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "object_id")
    private BusinessObject objectId;

    @XmlElement(name = "privilege-list")
    @Column(name = "privilege_list")
    private String privilegeList;

    public long getId() {
        return id;
    }

    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public BusinessObject getObjectId() {
        return objectId;
    }

    public void setObjectId(BusinessObject objectId) {
        this.objectId = objectId;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getSubRoleId() {
        return subRoleId;
    }

    public void setSubRoleId(long subRoleId) {
        this.subRoleId = subRoleId;
    }


    public String getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(String privilegeList) {
        this.privilegeList = privilegeList;
    }
}
