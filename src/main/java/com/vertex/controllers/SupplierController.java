package com.vertex.controllers;

import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import com.vertex.repositories.ISupplierRepository;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/supplier")
public class SupplierController {

    private final ISupplierRepository supplierSerivce;

    public SupplierController(ISupplierRepository supplierSerivce) {
        this.supplierSerivce = supplierSerivce;
    }

    @Get
    public Publisher<AccountingSupplierPartyDto> list() {
        return supplierSerivce.list();
    }

    @Post
    public Mono<HttpStatus> save(@NonNull @NotNull @Valid AccountingSupplierPartyDto supplierPartyDto) {
        return supplierSerivce.save(supplierPartyDto).map(added -> (added) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
}
