package com.trillia.entities;

import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "MerchantBillingPlanMap", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId"})})
@Indexed(index = "MerchantBillingPlanMap")

public class MerchantBillingPlanMap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "merchant_bill_plan_id", nullable = false)
    @XmlElement(name = "merchant-bill-plan-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;


    @XmlElement(name = "merchant-id")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "merchant_id")
    private Merchant merchantId;


    @XmlElement(name = "bill-plan-id")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "bill_plan_id", referencedColumnName = "bill_plan_id")
    private SubscriptionPlan billPlanId;


    @XmlElement(name = "effective-from")
    @Column(name = "effective_from")
    private Date effectiveFrom;


    @XmlElement(name = "effective-to")
    @Column(name = "effective_to")
    private Date effectiveTo;


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

    public Merchant getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Merchant merchantId) {
        this.merchantId = merchantId;
    }

    public SubscriptionPlan getBillPlanId() {
        return billPlanId;
    }

    public void setBillPlanId(SubscriptionPlan billPlanId) {
        this.billPlanId = billPlanId;
    }

    public Date getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(Date effectiveTo) {
        this.effectiveTo = effectiveTo;
    }
}
