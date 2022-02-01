package com.vertex.custom;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@Introspected
public class PartyLegalEntity {

    @JsonProperty("RegistrationName")
    @BsonProperty("RegistrationName")
    private String registrationName;

    @JsonProperty("CompanyID")
    @BsonProperty("CompanyID")
    private String companyId;




    @BsonCreator
    public PartyLegalEntity(@BsonProperty("RegistrationName") String registrationName,
                            @BsonProperty("CompanyID") String companyId) {
        this.registrationName = registrationName;
        this.companyId = companyId;
    }


}
