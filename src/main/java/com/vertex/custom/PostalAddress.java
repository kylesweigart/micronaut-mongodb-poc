package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAdditionalStreetName() {
        return additionalStreetName;
    }

    public void setAdditionalStreetName(String additionalStreetName) {
        this.additionalStreetName = additionalStreetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalZone() {
        return postalZone;
    }

    public void setPostalZone(String postalZone) {
        this.postalZone = postalZone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
