package com.xlenc.locator;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import com.xlenc.locator.api.LocatorState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * User: Michael Williams
 * Date: 8/23/12
 * Time: 11:48 PM
 */
@Configuration
@ComponentScan(basePackages = "com.xlenc.locator", useDefaultFilters = true)
public class LocatorConfig {


    public static final String DB_NAME = "locator";

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo("localhost");
    }

    @Bean
    public Morphia morphia() {
        return new Morphia();
    }

    @Bean
    public LocatorPersistence locatorPersistence() throws UnknownHostException {
        final BasicDAO<LocatorStateImpl, Object> locatorStateBasicDAO;
        locatorStateBasicDAO = new BasicDAO<LocatorStateImpl, Object>(
                LocatorStateImpl.class, mongo(), morphia(), DB_NAME
        );
        return new LocatorPersistenceImpl(locatorStateBasicDAO);
    }

}
