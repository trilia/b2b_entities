package com.trillia.jpa.entities;

import com.trillia.jpa.fieldbridge.SubscriberBridge;
import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mmathew on 26/05/16.
 */
@Entity
@Table(name = "trl_roles",uniqueConstraints={@UniqueConstraint(columnNames={"tenant_id","role_code"})})
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("Role")
@FullTextFilterDef(name="filter-role", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="Role", namespace="http://trilia-cloud.com/schema/entity/ut/Role/")
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({



        @NamedQuery(name = "Role.findAllRoles", query = "SELECT t from Role t")

}
)

public class Role extends RevisionControl  implements Serializable{

    @XmlElement(name = "tenant-id")
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
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


    @OneToMany(mappedBy = "userId")
    private List<UserRoleAssociation> userRoleAssociationList;

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

    public List<UserRoleAssociation> getUserRoleAssociationList() {
        return userRoleAssociationList;
    }

    public void setUserRoleAssociationList(List<UserRoleAssociation> userRoleAssociationList) {
        this.userRoleAssociationList = userRoleAssociationList;
    }
}
