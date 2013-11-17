package com.xlenc.locator.api;


/**
 * User: Michael Williams
 * Date: 1/6/13
 * Time: 3:25 AM
 */
public interface SiteState {
    String getPurpose();

    SiteTypeState getSiteTypeState();

    String getNumber();

    String getFloor();

    LocationState getLocationState();

    void setPurpose(String purpose);

    void setSiteTypeState(SiteTypeState siteTypeState);

    void setNumber(String number);

    void setFloor(String floor);

    void setLocationState(LocationState locationState);
}
