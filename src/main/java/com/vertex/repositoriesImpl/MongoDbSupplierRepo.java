package com.vertex.repositoriesImpl;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.vertex.configuration.IMongoDbConfiguration;
import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import com.vertex.repositories.ISupplierRepository;
import com.vertex.util.SupplierDtoToDocument;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

/**
 * This class is the implementation of the methods found in the ISupplierRepository interface.
 * The @Singleton annotation allows the injector to instantiate only one instance of the class.
 */
@Singleton
@Slf4j
public class MongoDbSupplierRepo implements ISupplierRepository {

    /**
     * private MongoDB configuration and Mongo Client fields are made.
     */
    private final IMongoDbConfiguration mongoDbConfig;
    private final MongoClient mongoClient;

    public MongoDbSupplierRepo(IMongoDbConfiguration mongoDbConfig, MongoClient mongoClient) {
        this.mongoDbConfig = mongoDbConfig;
        this.mongoClient = mongoClient;
    }

    /**
     * The save method saves an AccountingSupplierPartyDto to the collection.
     * @param supplierPartyDto
     * @return returns reactive response that gets the collection and inserts one document.
     */
    @Override
    public Mono<HttpStatus> save(AccountingSupplierPartyDto supplierPartyDto) {
        log.info("Calling MongoDbRepoIml.save(). Saving supplierDTO to the 'supplier' collection: {}",
                supplierPartyDto);
        return Mono.from(getCollection().insertOne(SupplierDtoToDocument.dtoToDoc(supplierPartyDto)))
                .map(insertOneResult -> HttpStatus.CREATED).onErrorReturn(HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * The list method gets the documents stored in the supplier collection.
     * @return returns documents found
     */
    @Override
    @NonNull
    public Publisher<Document> list() {
        return getCollection().find();
    }

    /**
     * This method is a helper method for getting the MongoDB collection.
     * @return
     */
    @NonNull
    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase(mongoDbConfig.getName()).getCollection(mongoDbConfig.getCollection(),
                Document.class);
    }
}
