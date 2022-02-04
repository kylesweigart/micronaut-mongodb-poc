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

@Singleton
@Slf4j
public class MongoDbSupplierRepo implements ISupplierRepository {

    private final IMongoDbConfiguration mongoDbConfig;
    private final MongoClient mongoClient;

    public MongoDbSupplierRepo(IMongoDbConfiguration mongoDbConfig, MongoClient mongoClient) {
        this.mongoDbConfig = mongoDbConfig;
        this.mongoClient = mongoClient;
    }

    @Override
    public Mono<HttpStatus> save(AccountingSupplierPartyDto supplierPartyDto) {
        log.info("Calling MongoDbRepoIml.save(). Saving supplierDTO to the 'supplier' collection: {}",
                supplierPartyDto);
        return Mono.from(getCollection().insertOne(SupplierDtoToDocument.dtoToDoc(supplierPartyDto)))
                .map(insertOneResult -> HttpStatus.CREATED).onErrorReturn(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    @NonNull
    public Publisher<Document> list() {
        return getCollection().find();
    }

    @NonNull
    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase(mongoDbConfig.getName()).getCollection(mongoDbConfig.getCollection(),
                Document.class);
    }
}
