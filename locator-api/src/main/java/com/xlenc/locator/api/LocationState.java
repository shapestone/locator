package com.xlenc.locator.api;

/**
 * User: Michael Williams
 * Date: 1/6/13
 * Time: 3:19 AM
 */
public interface LocationState {

    String[] getTypes();

    String[] getValues();

    void setTypes(String[] types);

    void setValues(String[] values);

}
