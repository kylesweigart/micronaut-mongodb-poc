package com.vertex.repositories;

import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import io.micronaut.core.annotation.NonNull;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface ISupplierRepository {

    Publisher<AccountingSupplierPartyDto> list();

    Mono<Boolean> save(@NonNull @NotNull @Valid AccountingSupplierPartyDto supplierPartyDto);
}
