package com.trillia.jpa.fieldbridge;

import com.trillia.jpa.entities.Subscriber;
import org.hibernate.search.bridge.StringBridge;

/**
 * Created by mmathew on 12/06/16.
 */
public class SubscriberBridge implements StringBridge {
    @Override
    public String objectToString(Object object) {
        return ((Subscriber)object).toString();
    }
}
