package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@Introspected

public class PartyTaxScheme  {

    @JsonProperty("CompanyID")
    @BsonProperty("CompanyID")
    private String companyId;

    @JsonProperty("TaxScheme")
    @BsonProperty(value = "TaxScheme")
    private TaxScheme taxScheme;



    @BsonCreator
    public PartyTaxScheme(@BsonProperty("CompanyID") String companyId, @BsonProperty("TaxScheme") TaxScheme taxScheme) {
        this.companyId = companyId;
        this.taxScheme = taxScheme;
    }


}
