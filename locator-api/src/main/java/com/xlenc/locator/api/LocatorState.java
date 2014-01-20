package com.xlenc.locator.api;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/6/13
 * Time: 3:16 AM
 */
public interface LocatorState {

    String getId();

    String getPartyId();

    LocatorTypeState getLocatorType();

    java.util.Date getFirstUsedDate();

    java.util.Date getLastUsedDate();

    java.util.Date getLastModifiedDate();

    java.util.Date getCreatedDate();

    Long getVersion();

    void setId(String id);

    void setPartyId(String partyId);

    void setLocatorType(LocatorTypeState locatorTypeState);

    void setFirstUsedDate(Date firstUsedDate);

    void setLastUsedDate(Date lastUsedDate);

    void setLastModifiedDate(Date lastModifiedDate);

    void setCreatedDate(Date createdDate);

    void setVersion(Long version);

}
