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
import java.util.Date;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "trl_employee_assignments", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-emp-assignment-by-tenant", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("EmployeeAssignment")
@XmlRootElement(name="EmployeeAssignment", namespace="http://trilia-cloud.com/schema/entity/ut/EmployeeAssignment/")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeAssignment extends RevisionControl  implements Serializable {





    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "employee-id")
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @XmlElement(name = "old-job-grade")
    @Column(name = "old_job_grade")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String oldJobGrade;


    @XmlElement(name = "new-job-grade")
    @Column(name = "new_job_grade")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String newJobGrade;


    @XmlElement(name = "old-manager")
    @Column(name = "old_manager")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String oldManager;

    @XmlElement(name = "new-manager")
    @Column(name = "new_manager")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String newManager;


    @XmlElement(name = "old-organization")
    @Column(name = "old_organization")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String oldOrganization;


    @XmlElement(name = "new-organization")
    @Column(name = "new_organization")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String newOrganization;


    @XmlElement(name = "old-department")
    @Column(name = "old_department")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String oldDepartment;


    @XmlElement(name = "new-department")
    @Column(name = "new_department")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String newDepartment;


    @XmlElement(name = "start-date")
    @Column(name = "start_date")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private Date startDate;


    @XmlElement(name = "end-date")
    @Column(name = "end_date")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private Date endDate;


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public String getOldJobGrade() {
        return oldJobGrade;
    }

    public void setOldJobGrade(String oldJobGrade) {
        this.oldJobGrade = oldJobGrade;
    }

    public String getNewJobGrade() {
        return newJobGrade;
    }

    public void setNewJobGrade(String newJobGrade) {
        this.newJobGrade = newJobGrade;
    }

    public String getOldManager() {
        return oldManager;
    }

    public void setOldManager(String oldManager) {
        this.oldManager = oldManager;
    }

    public String getNewManager() {
        return newManager;
    }

    public void setNewManager(String newManager) {
        this.newManager = newManager;
    }

    public String getOldOrganization() {
        return oldOrganization;
    }

    public void setOldOrganization(String oldOrganization) {
        this.oldOrganization = oldOrganization;
    }

    public String getNewOrganization() {
        return newOrganization;
    }

    public void setNewOrganization(String newOrganization) {
        this.newOrganization = newOrganization;
    }

    public String getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(String oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public String getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
