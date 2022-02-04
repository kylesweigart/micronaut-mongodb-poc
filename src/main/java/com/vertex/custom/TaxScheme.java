package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Introspected
public class TaxScheme {

    @JsonProperty("ID")
    @BsonProperty("ID")
    private String id;


    @BsonCreator
    public TaxScheme(@BsonProperty("ID") String id) {
        this.id = id;
    }


}
