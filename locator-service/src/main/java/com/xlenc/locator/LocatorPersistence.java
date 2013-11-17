package com.xlenc.locator;

import com.xlenc.locator.api.LocatorState;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 9:58 AM
 */
public interface LocatorPersistence {
    LocatorState add(LocatorState locatorState);

    LocatorState read(LocatorState locatorState);

    int delete(LocatorState locatorState);
}
