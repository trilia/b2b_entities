package com.trillia.jpa.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mmathew on 29/05/16.
 */
@Entity
@Table(name = "trl_revision_control")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@XmlRootElement(name="RevisionControl", namespace="http://trilia-cloud.com/schema/entity/ut/RevisionControl/")
@XmlAccessorType(XmlAccessType.FIELD)
//@DiscriminatorColumn(name = "RESOURCETYPE", discriminatorType = DiscriminatorType.STRING)
public class RevisionControl implements Serializable {


    public RevisionControl() {
        DiscriminatorValue discriminator = this.getClass().getAnnotation(DiscriminatorValue.class);
        if (null != discriminator) {
            this.resourceType = discriminator.value();
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @XmlElement(name = "id")
    private Long id;


    @XmlElement(name = "created-by-id")
    @Column(name = "created_by_id")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String createdById;


    @XmlElement(name = "created-by")
    @Column(name = "created_by")
    private String createdBy;


    @XmlElement(name = "created-date")
    @Column(name = "created_date")
    private Date createdDate;

    @XmlElement(name = "revised-by-id")
    @Column(name = "revised_by_id")
    private String revisedById;


    @XmlElement(name = "revised-date")
    @Column(name = "revised_date")
    private Date revisedDate;


    @XmlElement(name = "object-version-number")
    @Column(name = "object_version_number")
    private String objectVersionNumber;


    @Column(name = "RESOURCETYPE", nullable = false)
    protected String resourceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getRevisedById() {
        return revisedById;
    }

    public void setRevisedById(String revisedById) {
        this.revisedById = revisedById;
    }

    public Date getRevisedDate() {
        return revisedDate;
    }

    public void setRevisedDate(Date revisedDate) {
        this.revisedDate = revisedDate;
    }

    public String getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(String objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }
}
