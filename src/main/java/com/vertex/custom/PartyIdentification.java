package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Introspected
public class PartyIdentification {

    @JsonProperty("ID")
    @BsonProperty("ID")
    private String id;




    @BsonCreator
    public PartyIdentification(@BsonProperty("ID") String id) {
        this.id = id;
    }


}
