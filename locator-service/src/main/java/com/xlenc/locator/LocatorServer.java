package com.xlenc.locator;

import com.fasterxml.jackson.core.Version;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * User: Michael Williams
 * Date: 11/16/13
 * Time: 11:59 PM
 */
public class LocatorServer extends Service<LocatorServiceConfiguration> {

    @Override
    public void initialize(Bootstrap<LocatorServiceConfiguration> bootstrap) {
        bootstrap.setName("Party Rest Service");
        final String name = "PartyCustomModule";
        final Version snapshot = new Version(1, 0, 0, "SNAPSHOT", "com.xlenc.locator", "locator-service");
        final LocatorCustomModule partyCustomModule = new LocatorCustomModule(name, snapshot);
        bootstrap.getObjectMapperFactory().registerModule(partyCustomModule);
    }

    @Override
    public void run(LocatorServiceConfiguration configuration, Environment environment) throws Exception {
        final MongoDatabaseConfiguration mongoDatabaseConfiguration = configuration.getMongoDatabaseConfiguration();
        final String host = mongoDatabaseConfiguration.getHost();
        final int port = mongoDatabaseConfiguration.getPort();
        final Mongo mongo = new MongoClient(host, port);
        final Morphia morphia = new Morphia();
        final String databaseName = mongoDatabaseConfiguration.getDatabaseName();

        wirePartyListService(environment, mongo, morphia, databaseName);
        wireHealthChecks(environment, mongo);
    }

    private void wirePartyListService(Environment environment, Mongo mongo, Morphia morphia, String databaseName) {
        final LocatorPersistence credentialPersistence = new LocatorPersistenceImpl(mongo, morphia, databaseName);
        final LocatorService credentialService = new LocatorServiceImpl(credentialPersistence);
        final LocatorResource credentialResource = new LocatorResource(credentialService);
        environment.addResource(credentialResource);
    }

    private void wireHealthChecks(Environment environment, Mongo mongo) {
        environment.addHealthCheck(new MongoHealthCheck(mongo));
    }

    public static void main(String[] args) throws Exception {
        new LocatorServer().run(args);
    }

}

