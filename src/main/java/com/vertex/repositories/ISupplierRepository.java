package com.vertex.repositories;

import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import org.bson.Document;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface ISupplierRepository {

    Publisher<Document> list();

    Mono<HttpStatus> save(@NonNull @NotNull @Valid AccountingSupplierPartyDto supplierPartyDto);
}
