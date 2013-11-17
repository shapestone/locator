package com.xlenc.locator;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;

/**
 * User: Michael Williams
 * Date: 11/17/13
 * Time: 12:21 AM
 */
public class MongoHealthCheck extends HealthCheck {

    private final Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        super("MongoHealthCheck");
        this.mongo = mongo;
    }

    @Override
    protected HealthCheck.Result check() throws Exception {
        mongo.getDatabaseNames();
        return HealthCheck.Result.healthy();
    }

}
