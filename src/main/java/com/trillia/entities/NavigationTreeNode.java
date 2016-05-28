package com.trillia.entities;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created by mmathew on 27/05/16.
 */


@Entity
@Table(name = "trl_navigation_tree_nodes", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId"})})
@Indexed(index = "NavigationTreeNodes")
public class NavigationTreeNode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tree_node_id", nullable = false)
    @XmlElement(name = "tree-node-id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;


    @XmlElement(name = "tree-id")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @ManyToOne
    @JoinColumn(name = "tree_id", referencedColumnName = "tree_id")
    private NavigationTree treeId;


    @XmlElement(name = "node-type")
    @Column(name = "node_type")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String nodeType;


    @XmlElement(name = "node-builder")
    @Column(name = "node_builder")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String nodeBuilder;


    @XmlElement(name = "display-prompt")
    @Column(name = "display_prompt")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String displayPrompt;


    @XmlElement(name = "display-icon")
    @Column(name = "display_icon")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String displayIcon;


    @XmlElement(name = "nav-elem-id")
    @Column(name = "nav_elem_id")
    @Fields({
            @Field,
            @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String navElemId;

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

    public NavigationTree getTreeId() {
        return treeId;
    }

    public void setTreeId(NavigationTree treeId) {
        this.treeId = treeId;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeBuilder() {
        return nodeBuilder;
    }

    public void setNodeBuilder(String nodeBuilder) {
        this.nodeBuilder = nodeBuilder;
    }

    public String getDisplayPrompt() {
        return displayPrompt;
    }

    public void setDisplayPrompt(String displayPrompt) {
        this.displayPrompt = displayPrompt;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getNavElemId() {
        return navElemId;
    }

    public void setNavElemId(String navElemId) {
        this.navElemId = navElemId;
    }
}
