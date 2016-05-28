package com.trillia.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by mmathew on 26/05/16.
 */
@Entity
@Table(name = "trl_roles",uniqueConstraints={@UniqueConstraint(columnNames={"tenantId","roleCode"})})
@Indexed(index = "Roles")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    @XmlElement(name = "role-id")
    private long id;

    @XmlElement(name = "tenant-id")
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;

    @XmlElement(name = "role-code")
    @Column(name = "role_code")
    @Fields({
            @Field,
            @Field( index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO, store = Store.YES)
    })
    private String roleCode;




    @XmlElement(name = "role-name")
    @Column(name = "role_name")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String roleName;




    @XmlElement(name = "role-source")
    @Column(name = "role_source")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String roleSource;



    @XmlElement(name = "enabled-flag")
    @Column(name = "enabled_flag")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private boolean isEnabled;

    @XmlElement(name = "ext-role-ref")
    @Column(name = "external_role_reference")
    private String externalRoleReference;




    @XmlElement(name = "status")
    @Column(name = "status")
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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSource() {
        return roleSource;
    }

    public void setRoleSource(String roleSource) {
        this.roleSource = roleSource;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getExternalRoleReference() {
        return externalRoleReference;
    }

    public void setExternalRoleReference(String externalRoleReference) {
        this.externalRoleReference = externalRoleReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
