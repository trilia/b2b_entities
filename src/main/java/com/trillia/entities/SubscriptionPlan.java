package com.trillia.entities;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "trl_subscription_plans",uniqueConstraints={@UniqueConstraint(columnNames={"billPlanCode"})})
@Indexed(index = "SubscriptionPlan")
public class SubscriptionPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_plan_id", nullable = false)
    @XmlElement(name = "bill-plan-id")
    private long id;


    @XmlElement(name = "bill-plan-code")
    @Column(name = "bill_plan_code")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private long billPlanCode;


    @XmlElement(name = "bill-plan-name")
    @Column(name = "bill_plan_name")
    @Fields({
            @Field,
            @Field(index = Index.YES,analyze = Analyze.YES, store = Store.YES)
    })
    private String billPlanName;


    @XmlElement(name = "plan-category")
    @Column(name = "plan_category")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String planCategory;


    @XmlElement(name = "is-enabled")
    @Column(name = "is_enabled")

    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    private boolean isEnabled;


    @XmlElement(name = "rule-reference")
    @Column(name = "rule_reference")
    private String ruleReference;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBillPlanCode() {
        return billPlanCode;
    }

    public void setBillPlanCode(long billPlanCode) {
        this.billPlanCode = billPlanCode;
    }

    public String getBillPlanName() {
        return billPlanName;
    }

    public void setBillPlanName(String billPlanName) {
        this.billPlanName = billPlanName;
    }

    public String getPlanCategory() {
        return planCategory;
    }

    public void setPlanCategory(String planCategory) {
        this.planCategory = planCategory;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getRuleReference() {
        return ruleReference;
    }

    public void setRuleReference(String ruleReference) {
        this.ruleReference = ruleReference;
    }
}
