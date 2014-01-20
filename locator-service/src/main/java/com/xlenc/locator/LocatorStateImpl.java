package com.xlenc.locator;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Version;
import com.xlenc.locator.api.LocatorState;
import com.xlenc.locator.api.LocatorTypeState;
import lombok.Data;

import java.util.Date;

/**
 * User: Michael Williams
 * Date: 1/19/11
 * Time: 12:10 AM
 */
@Entity("locators")
public  @Data class LocatorStateImpl implements LocatorState {

    @Id
    private String id;
    @Property("partyId")
    private String partyId;
    @Embedded("type")
    private LocatorTypeState locatorType;
    @Property("firstUsedDate")
    private Date firstUsedDate;
    @Property("lastUsedDate")
    private Date lastUsedDate;
    @Property("lastModifiedDate")
    private Date lastModifiedDate;
    @Property("createdDate")
    private Date createdDate;
    @Version
    private Long version;

    public LocatorStateImpl() {
    }

    public LocatorStateImpl(String id) {
        this.id = id;
    }

}
