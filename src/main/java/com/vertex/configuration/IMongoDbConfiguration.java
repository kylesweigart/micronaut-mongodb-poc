package com.vertex.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.naming.Named;

/**
 * MongoDB configuration interface for Micronaut application.
 * The @ConfigurationProperties annotation contains the "db" value to define the database name and collection in the
 * application.yml file.
 */
@ConfigurationProperties("db")
public interface IMongoDbConfiguration extends Named {

    /**
     * @return returns a MongoDB collection
     */
    @NonNull
    String getCollection();
}
