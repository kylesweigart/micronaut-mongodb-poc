package com.vertex.dataTransferObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vertex.custom.Party;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;


@Introspected
public class AccountingSupplierPartyDto {

    @JsonProperty("Party")
    @BsonProperty(value = "Party")
    private Party party;


    @BsonCreator
    public AccountingSupplierPartyDto(@BsonProperty("Party") Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}