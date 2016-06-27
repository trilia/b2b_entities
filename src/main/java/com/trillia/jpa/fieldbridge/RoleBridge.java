package com.trillia.jpa.fieldbridge;

import com.trillia.jpa.entities.Role;
import org.hibernate.search.bridge.StringBridge;

/**
 * Created by mmathew on 24/06/16.
 */
public class RoleBridge implements StringBridge {
    @Override
    public String objectToString(Object object) {
        return ((Role)object).toString();
    }
}
