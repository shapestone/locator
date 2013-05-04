package com.xlenc.locator;

import com.google.code.morphia.annotations.Embedded;
import com.xlenc.locator.api.PostalState;
import com.xlenc.locator.api.SiteState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User: Michael Williams
 * Date: 1/19/11
 * Time: 12:11 AM
 */
@EqualsAndHashCode(callSuper = false)
public @Data class PostalStateImpl extends LocatorStateImpl implements PostalState {

    @Embedded("site")
    private SiteState siteState;

    public PostalStateImpl() {
    }

    public PostalStateImpl(String id) {
        super(id);
    }

}
