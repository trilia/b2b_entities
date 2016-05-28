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
@Table(name = "trl_navigation_elements", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenantId","navElemCode"})})
@Indexed(index = "NavigationElements")
public class NavigationElements implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nav-elem-id", nullable = false)
    @XmlElement(name = "nav_elem_id")
    private long id;


    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "tenant_id")
    private Subscriber tenantId;


    @XmlElement(name = "nav-elem-code")
    @Column(name = "nav_elem_code")
    @Fields({
            @Field,
            @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String navElemCode;


    @XmlElement(name = "display-prompt")
    @Column(name = "display_prompt")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    })
    private String displayPrompt;


    @XmlElement(name = "object-id")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "object_id")
    private BusinessObject objectId;


    @XmlElement(name = "category")
    @Column(name = "category")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String category;


    @XmlElement(name = "page-type")
    @Column(name = "page_type")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String pageType;


    @XmlElement(name = "page-uri")
    @Column(name = "page_uri")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String pageURI;


    @XmlElement(name = "display-icon")
    @Column(name = "display_icon")
    @Fields({
            @Field,
            @Field( index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    })
    private String displayIcon;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNavElemCode() {
        return navElemCode;
    }

    public void setNavElemCode(String navElemCode) {
        this.navElemCode = navElemCode;
    }

    public String getDisplayPrompt() {
        return displayPrompt;
    }

    public void setDisplayPrompt(String displayPrompt) {
        this.displayPrompt = displayPrompt;
    }

    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public BusinessObject getObjectId() {
        return objectId;
    }

    public void setObjectId(BusinessObject objectId) {
        this.objectId = objectId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getPageURI() {
        return pageURI;
    }

    public void setPageURI(String pageURI) {
        this.pageURI = pageURI;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }
}
