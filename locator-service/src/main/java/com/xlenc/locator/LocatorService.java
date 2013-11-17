package com.xlenc.locator;

import com.xlenc.locator.api.LocatorState;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 9:52 AM
 */
public interface LocatorService {

    LocatorState add(LocatorState locatorState);

    LocatorState read(LocatorState locatorState);

    int delete(LocatorState locatorState);
}
