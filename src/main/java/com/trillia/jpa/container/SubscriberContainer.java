package com.trillia.jpa.container;

import com.trillia.jpa.entities.Role;
import com.trillia.jpa.entities.Subscriber;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by mmathew on 23/06/16.
 */


@XmlRootElement(name = "subscriberList", namespace = "http://trilia-cloud.com/schema/entity/ut/Subscriber/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"subscriberList"})
public class SubscriberContainer {


    @XmlElement(name = "subscriber")
    private List<Subscriber> subscriberList;

    public List<Subscriber> getEntityList() {
        return subscriberList;
    }

    public void setEnityList(List<Subscriber> roleList) {
        this.subscriberList = roleList;
    }
}
