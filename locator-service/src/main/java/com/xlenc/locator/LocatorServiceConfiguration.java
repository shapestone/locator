package com.xlenc.locator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User: Michael Williams
 * Date: 11/17/13
 * Time: 12:15 AM
 */
public @Data
class LocatorServiceConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("mongoDatabase")
    private MongoDatabaseConfiguration mongoDatabaseConfiguration = new MongoDatabaseConfiguration();

}
