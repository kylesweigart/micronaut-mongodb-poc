package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Introspected
public class Party {

    @JsonProperty("EndpointID")
    @BsonProperty(value = "EndpointID")
    private EndpointID endpointID;

    @JsonProperty("PartyIdentification")
    @BsonProperty(value = "PartyIdentification")
    private PartyIdentification partyIdentification;

    @JsonProperty("PartyName")
    @BsonProperty(value = "PartyName")
    private PartyName partyName;

    @JsonProperty("PostalAddress")
    @BsonProperty(value = "PostalAddress")
    private PostalAddress postalAddress;

    @JsonProperty("PartyTaxScheme")
    @BsonProperty(value = "PartyTaxScheme")
    private PartyTaxScheme partyTaxScheme;

    @JsonProperty("PartyLegalEntity")
    @BsonProperty(value = "PartyLegalEntity")
    private PartyLegalEntity partyLegalEntity;


    @BsonCreator
    public Party(@BsonProperty("EndpointID") EndpointID endpointID,
                 @BsonProperty("PartyIdentification") PartyIdentification partyIdentification, @BsonProperty(
                         "PartyName") PartyName partyName, @BsonProperty("PostalAddress") PostalAddress postalAddress
            , @BsonProperty("PartyTaxScheme") PartyTaxScheme partyTaxScheme,
                 @BsonProperty("PartyLegalEntity") PartyLegalEntity partyLegalEntity) {
        this.endpointID = endpointID;
        this.partyIdentification = partyIdentification;
        this.partyName = partyName;
        this.postalAddress = postalAddress;
        this.partyTaxScheme = partyTaxScheme;
        this.partyLegalEntity = partyLegalEntity;
    }

    public EndpointID getEndpointID() {
        return endpointID;
    }

    public void setEndpointID(EndpointID endpointID) {
        this.endpointID = endpointID;
    }

    public PartyIdentification getPartyIdentification() {
        return partyIdentification;
    }

    public void setPartyIdentification(PartyIdentification partyIdentification) {
        this.partyIdentification = partyIdentification;
    }

    public PartyName getPartyName() {
        return partyName;
    }

    public void setPartyName(PartyName partyName) {
        this.partyName = partyName;
    }

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public PartyTaxScheme getPartyTaxScheme() {
        return partyTaxScheme;
    }

    public void setPartyTaxScheme(PartyTaxScheme partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public void setPartyLegalEntity(PartyLegalEntity partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }
}
