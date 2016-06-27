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
@Table(name = "trl_departments", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"}), @UniqueConstraint(columnNames = {"deptartment_code"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-dept-by-tenant", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("Department")
@XmlRootElement(name="Department", namespace="http://trilia-cloud.com/schema/entity/ut/Department/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department extends RevisionControl  implements Serializable {




    @XmlElement(name = "tenant-id")
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "department-code")
    @Column(name = "deptartment_code")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String departmentCode;


    @XmlElement(name = "department-name")
    @Column(name = "department_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    })
    private String departmentName;


    @XmlElement(name = "enabled-flag")
    @Column(name = "enabled_flag")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private boolean isEnabled;


    @XmlElement(name = "cost-center")
    @Column(name = "cost_center")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String costCenter;
//TODO EMPLOYEES



    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }
}
