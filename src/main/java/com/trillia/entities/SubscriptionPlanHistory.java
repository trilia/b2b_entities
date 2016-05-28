package com.trillia.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mmathew on 27/05/16.
 */

@Entity
@Table(name = "trl_subscription_plan_history",uniqueConstraints={@UniqueConstraint(columnNames={"tenantId"}),@UniqueConstraint(columnNames = {"roleCode"})})
@Indexed(index = "SubscriptionPlanHistory")
public class SubscriptionPlanHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plan_history_id", nullable = false)
    @XmlElement(name = "plan-history-id")
    private long id;

    @XmlElement(name = "bill-plan-id")
    @ManyToOne
    @JoinColumn(name = "bill_plan_id", referencedColumnName = "id")
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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


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
