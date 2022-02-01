package com.vertex.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.naming.Named;

@ConfigurationProperties("db")
public interface IMongoDbConfiguration extends Named {
    @NonNull
    String getCollection();
}
