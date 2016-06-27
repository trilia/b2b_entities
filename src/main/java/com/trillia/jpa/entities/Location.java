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
@Table(name = "trl_locations", uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant_id","location_alias"})})
@Indexed(index = "SetupDataIndex")
@FullTextFilterDef(name="filter-location-by-tenant", impl=TenantBasedSearchFilterFactory.class)
//@DiscriminatorValue("Location")
@XmlRootElement(name="Location", namespace="http://trilia-cloud.com/schema/entity/ut/Location/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location extends RevisionControl  {



    @XmlElement(name = "tenant-id")
    @Fields({
            @Field,
            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="tenant_id")
    @FieldBridge(impl = SubscriberBridge.class)
    private Subscriber tenantId;


    @XmlElement(name = "location-alias")
    @Column(name = "location_alias")

    @Fields({
            @Field,
            @Field(index= Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private String locationAlias;


    @XmlElement(name = "location-type")
    @Column(name = "location_type")

    @Fields({
            @Field,
            @Field(index = Index.YES,analyze = Analyze.NO, store = Store.NO)
    })
    private String locationType;


    @XmlElement(name = "address")
    @Column(name = "address")

    @Fields({
            @Field,
            @Field(index = Index.YES,analyze = Analyze.NO, store = Store.YES)
    })
    private String address;


    @XmlElement(name = "city")
    @Column(name = "city")
    private String city;


    @XmlElement(name = "state")
    @Column(name = "state")
    private String state;


    @XmlElement(name = "country")
    @Column(name = "country")
    private String country;


    @XmlElement(name = "zip-code")
    @Column(name = "zip_code")
    private String zipCode;


    @XmlElement(name = "gps-lat-cord")
    @Column(name = "gps_lat_cord")
    private String gpsLatCord;


    public String getGpsLongCoord() {
        return gpsLongCoord;
    }

    public void setGpsLongCoord(String gpsLongCoord) {
        this.gpsLongCoord = gpsLongCoord;
    }


    public Subscriber getTenantId() {
        return tenantId;
    }

    public void setTenantId(Subscriber tenantId) {
        this.tenantId = tenantId;
    }

    public String getLocationAlias() {
        return locationAlias;
    }

    public void setLocationAlias(String locationAlias) {
        this.locationAlias = locationAlias;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGpsLatCord() {
        return gpsLatCord;
    }

    public void setGpsLatCord(String gpsLatCord) {
        this.gpsLatCord = gpsLatCord;
    }

    @XmlElement(name = "gps-long-cord")
    @Column(name = "gps_long_cord")

    @Fields({
            @Field,

            @Field(analyze = Analyze.NO, store = Store.YES)
    })
    private String gpsLongCoord;


}
