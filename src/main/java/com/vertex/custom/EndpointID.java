package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Introspected
public class EndpointID {

    @JsonProperty("@schemeID")
    @BsonProperty("@schemeID")
    public String schemeID;

    @JsonProperty("#text")
    @BsonProperty("#text")
    public String text;




    @BsonCreator
    public EndpointID(@BsonProperty("@schemeID") String schemeID, @BsonProperty("#text") String text) {
        this.schemeID = schemeID;
        this.text = text;
    }


}