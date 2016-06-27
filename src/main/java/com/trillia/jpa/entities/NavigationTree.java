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
@Table(name = "trl_navigation_tree", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id","tree_name"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-navigation-tree", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("NavigationTree")
@XmlRootElement(name="NavigationTree", namespace="http://trilia-cloud.com/schema/entity/ut/NavigationTree/")
@XmlAccessorType(XmlAccessType.FIELD)
public class NavigationTree extends RevisionControl  implements Serializable {



    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field( analyze = Analyze.NO, store = Store.YES)
    })

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "tree-name")
    @Column(name = "tree_name")
    @Fields({
            @Field,
            @Field( analyze = Analyze.NO, store = Store.YES)
    })
    private String treeName;


    @XmlElement(name = "nav-type")
    @Column(name = "nav_type")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String navType;


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getNavType() {
        return navType;
    }

    public void setNavType(String navType) {
        this.navType = navType;
    }
}
