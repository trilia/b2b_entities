package com.trillia.jpa.entities;

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
@Table(name = "trl_subscriber", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-subscriber", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="Subscriber", namespace="http://trilia-cloud.com/schema/entity/ut/Subscriber/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscriber implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tenant_id", nullable = false)
    @XmlElement(name = "tenant-id")
    private long id;


    @XmlElement(name = "partition-code")
    @Column(name = "partition_code")
    private String partitionCode;


    @XmlElement(name = "subscriber-name")
    @Column(name = "subscriber_name")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String subscriberName;

    @XmlElement(name = "subscriber-email")
    @Column(name = "subscriber_email")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String subscriberEmail;


    @XmlElement(name = "subscriber-phone")
    @Column(name = "subscriber_phone")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private String subscriberPhone;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPartitionCode() {
        return partitionCode;
    }

    public void setPartitionCode(String partitionCode) {
        this.partitionCode = partitionCode;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberEmail() {
        return subscriberEmail;
    }

    public void setSubscriberEmail(String subscriberEmail) {
        this.subscriberEmail = subscriberEmail;
    }

    public String getSubscriberPhone() {
        return subscriberPhone;
    }

    public void setSubscriberPhone(String subscriberPhone) {
        this.subscriberPhone = subscriberPhone;
    }
}
