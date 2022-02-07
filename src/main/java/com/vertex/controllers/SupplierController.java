package com.vertex.controllers;

import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import com.vertex.repositories.ISupplierRepository;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Controller containing API endpoints for the /supplier endpoint.
 */
@Controller("/supplier")
@Slf4j
public class SupplierController {

    /**
     * private ISupplierRepository field supplies the service to the controller
     */
    private final ISupplierRepository supplierSerivce;

    public SupplierController(ISupplierRepository supplierSerivce) {
        this.supplierSerivce = supplierSerivce;
    }

    /**
     * @return uses a GET request to find the MongoDB collection
     */
    @Get
    public Publisher<Document> list() {
        return supplierSerivce.list();
    }

    /**
     *
     * @param supplierPartyDto the data transfer object that makes up the AccountingSupplierParty fields in the
     *                         e-invoicing JSON file
     * @return returns a reactive save() call for the supplied supplierService object. A POST request attempts to
     * save the JSON data as a document in the MongoDB collection.
     */
    @Post
    public Mono<HttpStatus> save(@NonNull @NotNull @Valid AccountingSupplierPartyDto supplierPartyDto) {
        log.info("Executing POST request of type Mono<HttpStatus>");
        return supplierSerivce.save(supplierPartyDto);
    }
}
