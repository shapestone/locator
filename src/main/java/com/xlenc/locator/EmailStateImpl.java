package com.xlenc.locator;

import com.google.code.morphia.annotations.Property;
import com.xlenc.locator.api.EmailState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: Michael Williams
 * Date: 1/19/11
 * Time: 12:22 AM
 */
@EqualsAndHashCode(callSuper = false)
public @Data class EmailStateImpl extends LocatorStateImpl implements EmailState {
    @Property("address")
    private String address;
}
