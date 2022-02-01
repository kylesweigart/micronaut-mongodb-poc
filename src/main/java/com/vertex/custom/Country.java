package com.vertex.custom;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Introspected
public class Country {

    @JsonProperty("IdentificationCode")
    @BsonProperty("IdentificationCode")
    private String identificationCode;




    @BsonCreator
    public Country(@BsonProperty("IdentificationCode") String identificationCode) {
        this.identificationCode = identificationCode;
    }


}
