package com.xlenc.locator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * User: Michael Williams
 * Date: 11/17/13
 * Time: 12:14 AM
 */
public @Data
class MongoDatabaseConfiguration {

    @NotEmpty
    @JsonProperty
    private String host;

    @Min(1)
    @Max(65535)
    @JsonProperty
    private int port = 5672;

    @NotEmpty
    @JsonProperty
    private String databaseName;

}
