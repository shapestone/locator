package com.xlenc.locator;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.xlenc.locator.api.LocatorTypeState;

/**
 * User: Michael Williams
 * Date: 1/1/14
 * Time: 11:50 PM
 */
public class LocatorCustomModule extends SimpleModule {

    public LocatorCustomModule(String name, Version version) {
        super(name, version);
    }

    @Override
    public void setupModule(SetupContext context) {
        final SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(LocatorTypeState.class, LocatorTypeStateImpl.class);
        context.addAbstractTypeResolver(resolver);
        super.setupModule(context);
    }

}
