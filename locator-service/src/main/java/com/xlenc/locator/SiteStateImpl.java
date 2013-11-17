package com.xlenc.locator;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;
import com.xlenc.locator.api.LocationState;
import com.xlenc.locator.api.SiteState;
import com.xlenc.locator.api.SiteTypeState;
import lombok.Data;

/**
 * User: Michael Williams
 * Date: 1/19/11
 * Time: 12:49 AM
 */
public @Data class SiteStateImpl implements SiteState {

    @Property("purpose")
    private String purpose;
    @Embedded("type")
    private SiteTypeState siteTypeState;
    @Property("number")
    private String number;
    @Property("floor")
    private String floor;
    @Embedded("location")
    private LocationState locationState;

    public SiteStateImpl() {
    }

}
