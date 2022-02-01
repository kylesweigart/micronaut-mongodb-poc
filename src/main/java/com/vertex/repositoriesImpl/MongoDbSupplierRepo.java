package com.vertex.repositoriesImpl;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.vertex.configuration.IMongoDbConfiguration;
import com.vertex.dataTransferObjects.AccountingSupplierPartyDto;
import com.vertex.repositories.ISupplierRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Singleton
public class MongoDbSupplierRepo implements ISupplierRepository {

    private final IMongoDbConfiguration mongoDbConfig;
    private final MongoClient mongoClient;

    public MongoDbSupplierRepo(IMongoDbConfiguration mongoDbConfig, MongoClient mongoClient) {
        this.mongoDbConfig = mongoDbConfig;
        this.mongoClient = mongoClient;
    }

    @Override
    public Mono<Boolean> save(AccountingSupplierPartyDto supplierPartyDto) {
        return Mono.from(getCollection().insertOne(supplierPartyDto)).map(insertOneResult -> Boolean.TRUE)
                .onErrorReturn(Boolean.FALSE);
    }

    @Override
    @NonNull
    public Publisher<AccountingSupplierPartyDto> list() {
        return getCollection().find();
    }

    @NonNull
    private MongoCollection<AccountingSupplierPartyDto> getCollection() {
        return mongoClient.getDatabase(mongoDbConfig.getName()).getCollection(mongoDbConfig.getCollection(),
                AccountingSupplierPartyDto.class);
    }


}
