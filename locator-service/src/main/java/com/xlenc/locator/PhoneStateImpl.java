package com.xlenc.locator;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;
import com.xlenc.locator.api.PhoneState;
import com.xlenc.locator.api.PhoneTypeState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: Michael Williams
 * Date: 1/19/11
 * Time: 12:15 AM
 */
@EqualsAndHashCode(callSuper = false)
public @Data class PhoneStateImpl extends LocatorStateImpl implements PhoneState {

    @Embedded("type")
    private PhoneTypeState phoneTypeState;
    @Property("number")
    private String number;

    public PhoneStateImpl() {
    }

    public PhoneStateImpl(String id) {
        super(id);
    }
}
