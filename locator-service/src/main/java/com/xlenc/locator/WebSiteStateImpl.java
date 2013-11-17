package com.xlenc.locator;

import com.google.code.morphia.annotations.Property;
import com.xlenc.locator.api.WebSiteState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: Michael Williams
 * Date: 1/19/11
 * Time: 12:22 AM
 */
@EqualsAndHashCode(callSuper = false)
public @Data class WebSiteStateImpl extends LocatorStateImpl implements WebSiteState {
    @Property("url")
    private String url;
}
