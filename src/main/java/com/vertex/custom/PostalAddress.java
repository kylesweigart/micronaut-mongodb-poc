package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@Introspected

public class PostalAddress {

    @JsonProperty("StreetName")
    @BsonProperty("StreetName")
    private String streetName;

    @JsonProperty("AdditionalStreetName")
    @BsonProperty("AdditionalStreetName")
    private String additionalStreetName;

    @JsonProperty("CityName")
    @BsonProperty("CityName")
    private String cityName;

    @JsonProperty("PostalZone")
    @BsonProperty("PostalZone")
    private String postalZone;

    @JsonProperty("Country")
    @BsonProperty(value = "Country")
    private Country country;



    @BsonCreator
    public PostalAddress(@BsonProperty("StreetName") String streetName,
                         @BsonProperty("AdditionalStreetName") String additionalStreetName,
                         @BsonProperty("CityName") String cityName, @BsonProperty("PostalZone") String postalZone,
                         @BsonProperty("Country") Country country) {
        this.streetName = streetName;
        this.additionalStreetName = additionalStreetName;
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.country = country;
    }


}
