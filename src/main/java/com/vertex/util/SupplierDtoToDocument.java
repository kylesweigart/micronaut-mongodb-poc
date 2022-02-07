package com.vertex.util;

import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

/**
 * This utility class converts a data transfer object into a Document object.
 */
@Slf4j
public class SupplierDtoToDocument {
    public static Document dtoToDoc(AccountingSupplierPartyDto supplierPartyDto) {
        Document document = new Document();
        return document.append("Party",
                new Document().append("EndpointID",
                        new Document().append("@schemeID",
                                supplierPartyDto.getParty().getEndpointID().getSchemeID()).append("#text",
                                supplierPartyDto.getParty().getEndpointID().getText())).append("PartyIdentification",
                        new Document().append("ID",
                                supplierPartyDto.getParty().getPartyIdentification().getId())).append("PartyName",
                        new Document().append("Name",
                                supplierPartyDto.getParty().getPartyName().getName())).append("PostalAddress",
                        new Document().append("StreetName",
                                        supplierPartyDto.getParty().getPostalAddress().getStreetName())
                                .append("AdditionalStreetName",
                                        supplierPartyDto.getParty().getPostalAddress().getAdditionalStreetName())
                                .append("CityName",
                                        supplierPartyDto.getParty().getPostalAddress().getCityName())
                                .append("PostalZone",
                                        supplierPartyDto.getParty().getPostalAddress().getPostalZone())
                                .append("Country",
                                        new Document().append("IdentificationCode",
                                                supplierPartyDto.getParty().getPostalAddress().getCountry()
                                                        .getIdentificationCode()))));
    }
}
