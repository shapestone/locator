package com.xlenc.locator;

import com.xlenc.locator.api.LocatorState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 9:53 AM
 */
@Service
public class LocatorServiceImpl implements LocatorService {

    @Autowired
    private LocatorPersistence locatorPersistence;

    @Override
    public LocatorState add(LocatorState locatorState) {
        notNull(locatorState);
        return locatorPersistence.add(locatorState);
    }

    @Override
    public LocatorState read(LocatorState locatorState) {
        notNull(locatorState);
        notNull(locatorState.getId());
        return locatorPersistence.read(locatorState);
    }

    @Override
    public int delete(LocatorState locatorState) {
        notNull(locatorState);
        notNull(locatorState.getId());
        return locatorPersistence.delete(locatorState);
    }

}
