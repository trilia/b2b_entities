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
@Table(name = "trl_employees",uniqueConstraints={@UniqueConstraint(columnNames={"tenant_id","employee_code"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-employee-by-tenant", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("Employee")
@XmlRootElement(name="Employee", namespace="http://trilia-cloud.com/schema/entity/ut/Employee/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends RevisionControl {




    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field( analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "employee-code")
    @Column(name = "employee_code")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String employeeCode;


    @XmlElement(name = "first-name")
    @Column(name = "first_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String firstName;


    @XmlElement(name = "middle-name")
    @Column(name = "middle_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String middleName;


    @XmlElement(name = "last-name")
    @Column(name = "last_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String lastName;


    @XmlElement(name = "family-name")
    @Column(name = "family_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String familyName;


    @XmlElement(name = "date-of-joining")
    @Column(name = "date_of_joining")

    @Fields({
            @Field,
            @Field(index = Index.YES,analyze = Analyze.NO, store = Store.YES)
    })
    private Date dateOfJoining;


    @XmlElement(name = "date-of-birth")
    @Column(name = "date_of_birth")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private Date dateOfBirth;


    @XmlElement(name = "identification-type")
    @Column(name = "identification_type")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String identificationType;


    @XmlElement(name = "identification-number")
    @Column(name = "identification_number")

    @Fields({
            @Field,
            @Field(index = Index.YES,analyze = Analyze.NO, store = Store.YES)
    })
    private String identificationNumber;


    @XmlElement(name = "phone-number")
    @Column(name = "phone_number")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })

    private String phoneNumber;


    @XmlElement(name = "email")
    @Column(name = "email")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String email;


    @XmlElement(name = "is-active")
    @Column(name = "is_active")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private Boolean isActive;


    @XmlElement(name = "user-name")
    @Column(name = "user_name")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
   // @SortableField(forField = "tenantId-sort")
    private String userName;



    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
