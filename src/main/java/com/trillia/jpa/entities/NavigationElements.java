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
@Table(name = "trl_navigation_elements", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id","nav_elem_code"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-navigation-elements", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("NavigationElements")
@XmlRootElement(name="NavigationElements", namespace="http://trilia-cloud.com/schema/entity/ut/NavigationElements/")
@XmlAccessorType(XmlAccessType.FIELD)
public class NavigationElements extends RevisionControl  implements Serializable {



    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @ManyToOne
    @JoinColumn(name = "tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
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
    @JoinColumn(name = "object_id")
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
