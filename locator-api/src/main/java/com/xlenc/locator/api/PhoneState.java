package com.xlenc.locator.api;

/**
 * User: Michael Williams
 * Date: 1/6/13
 * Time: 3:23 AM
 */
public interface PhoneState {
    PhoneTypeState getPhoneTypeState();

    String getNumber();

    void setPhoneTypeState(PhoneTypeState phoneTypeState);

    void setNumber(String number);
}
