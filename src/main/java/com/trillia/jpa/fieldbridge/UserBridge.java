package com.trillia.jpa.fieldbridge;

import com.trillia.jpa.entities.Users;
import org.hibernate.search.bridge.StringBridge;

/**
 * Created by mmathew on 12/06/16.
 */
public class UserBridge implements StringBridge {
    @Override
    public String objectToString(Object object) {
        return ((Users)object).toString();
    }
}
