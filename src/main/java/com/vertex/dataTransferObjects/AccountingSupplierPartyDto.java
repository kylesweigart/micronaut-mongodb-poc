package com.vertex.dataTransferObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vertex.custom.Party;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 * The AccountingSupplierPartyDto class is a data structure that is made up of all fields found in the
 * AccountingSupplierParty group within the e-invoicing JSON file.
 * The @Introspected annotation produces a BeanIntrospection at compilation time.
 */
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