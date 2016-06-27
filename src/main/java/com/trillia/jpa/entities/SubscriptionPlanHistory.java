package com.trillia.jpa.entities;

import com.trillia.jpa.utilities.TenantBasedSearchFilterFactory;
import org.hibernate.search.annotations.*;

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
@Table(name = "trl_subscription_plan_history",uniqueConstraints={@UniqueConstraint(columnNames={"bill_plan_id"})})
@Indexed(index = "SetupDataIndex")
//@DiscriminatorValue("SubscriptionPlanHistory")
@FullTextFilterDef(name="filter-subscription-plan-history", impl=TenantBasedSearchFilterFactory.class)
@XmlRootElement(name="SubscriptionPlanHistory", namespace="http://trilia-cloud.com/schema/entity/ut/SubscriptionPlanHistory/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionPlanHistory  extends RevisionControl   {



    @XmlElement(name = "bill-plan-id")
    @ManyToOne
    @JoinColumn(name = "bill_plan_id")
    private SubscriptionPlan subscriptionPlan;


    @XmlElement(name = "start-date")
    @Column(name = "start_date")
    @Fields({
            @Field,
            @Field( index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private Date startDate;


    @XmlElement(name = "end-date")
    @Column(name = "end_date")
    @Fields({
            @Field,
            @Field( index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private Date endDate;


    @XmlElement(name = "old-value")
    @Column(name = "old_value")
    @Fields({
            @Field,
            @Field( index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private boolean oldValue;


    @XmlElement(name = "new-value")
    @Column(name = "new_value")
    @Fields({
            @Field,
            @Field( index = org.hibernate.search.annotations.Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private boolean newValue;



    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isOldValue() {
        return oldValue;
    }

    public void setOldValue(boolean oldValue) {
        this.oldValue = oldValue;
    }

    public boolean isNewValue() {
        return newValue;
    }

    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}
