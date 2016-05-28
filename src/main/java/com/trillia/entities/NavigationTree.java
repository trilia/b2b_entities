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
@Table(name = "trl_navigation_tree", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId","treeName"})})
@Indexed(index = "NavigationTree")
public class NavigationTree implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tree_id", nullable = false)
    @XmlElement(name = "tree-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field( analyze = Analyze.NO, store = Store.YES)
    })

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
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
