package com.xlenc.locator;

import com.google.code.morphia.annotations.Property;
import com.xlenc.locator.api.LocationState;
import lombok.Data;

/**
 * User: Michael Williams
 * Date: 12/4/12
 * Time: 11:06 PM
 */
public @Data class LocationStateImpl implements LocationState {

    @Property("types")
    private String[] types;
    @Property("values")
    private String[] values;

}
